import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { Placeholder } from '@angular/compiler/src/i18n/i18n_ast';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class VoteService {

  constructor(private http: HttpClient, private auth: AuthService) { }

  private voteUrl = "https://cuisinas.herokuapp.com/api/vote"

  getVotesFromRecipe(recipeId : number) {
    let url = this.voteUrl + "/" + recipeId
    return this.http.get(url)
  }

  addVote(value : number, recipeId: number){
    this.auth.getCurrentUserId().subscribe((data)=>{
      let id = data["userId"]
      const body = 
      { recipeId: recipeId,
        userId: id,
        voteValue: value
       };
       console.log(body)
      this.http.post(this.voteUrl,body).toPromise()
    })
}

}