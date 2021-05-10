import { Injectable } from '@angular/core';
import { element } from 'protractor';
import {Ingredient} from './interfaces/Ingredient'
import {INGREDIENTS} from './Mock/MockIngredient'
import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { concat, Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { from } from 'rxjs';

 
@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private filtered : Ingredient[];
  private ingredientRecipeUrl = 'https://cuisinas.herokuapp.com/api/recipe/ingredient/'
  private ingredientUrl = 'https://cuisinas.herokuapp.com/api/ingredient';
  private findIngredientsUrl = 'https://cuisinas.herokuapp.com/api/ingredient/find'

  getHttpIngredient() {
    let i = this.http.get(this.ingredientUrl);
    return i;
  }

  getIngredientsById(id : number){
    let url = this.ingredientRecipeUrl.concat(id.toString())
    return this.http.get(url);
    }

  searchIngredientBySubStr(subStr : string){
    let params = new HttpParams().set("ingredientNameSubStr",subStr)
    let i = this.http.get(this.findIngredientsUrl, {params: params});
    
    console.log(i);
    return i; 
  }

  constructor(private http: HttpClient) { }

  
}
