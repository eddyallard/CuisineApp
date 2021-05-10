import { Injectable } from '@angular/core';
import {User} from './interfaces/user';
import { HttpClient, HttpHeaders,HttpParams, HttpResponse } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';
 
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  private loginUrl = 'https://cuisinas.herokuapp.com/api/user/login';
  private signUpUrl = 'https://cuisinas.herokuapp.com/api/user/signup';

  private helper = new JwtHelperService();

  postUser(user : User) {
    const body = 
      { userName: user.UserName,
        email: user.Email,
        userPassword: user.Password
       };
    this.http.post(this.signUpUrl,body).toPromise();
  }

  login(user : User){
    const body = 
      { username: user.UserName,
        password: user.Password
       };
    this.http.post(this.loginUrl,body,{observe: 'response'})
  .subscribe(resp => {
   let token = resp.headers.get('Authorization');
   console.log(token);
   localStorage.setItem('token', token);
  });
    
  }

  getToken(){
    if (this.isAuthenticated()){
      return localStorage.getItem('token');
    }
    return "";
  }

  getCurrentUserName() {
    return this.helper.decodeToken(localStorage.getItem('token')).sub;
  }

  isAuthenticated(): Boolean{
    let token = localStorage.getItem('token');
    if (token != null && this.tokenExpired(token) == false){
      return true;
    }
    return false
  }

  private tokenExpired(token: string) {
    const expiry = (JSON.parse(atob(token.split('.')[1]))).exp;
    return (Math.floor((new Date).getTime() / 1000)) >= expiry;
  }
}
