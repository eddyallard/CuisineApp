import { Component, OnInit } from '@angular/core';
import {AuthService} from '../auth.service';
import {User} from '../interfaces/user'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private auth : AuthService) { }

  model = new User(69420, '', '', '');

  submitted = false;

  onSignInSubmit() 
  {
    this.auth.login(this.model);
  }

  onRegisterSubmit() 
  {
    this.auth.postUser(this.model);
  }

}
