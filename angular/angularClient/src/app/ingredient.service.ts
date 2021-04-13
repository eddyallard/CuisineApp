import { Injectable } from '@angular/core';
import { element } from 'protractor';
import {Ingredient} from './interfaces/Ingredient'
import {INGREDIENTS} from './Mock/MockIngredient'
import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { concat, Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
 
@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private filtered : Ingredient[];
  private ingredientRecipeUrl = 'http://localhost:8080/api/recipe/ingredient/'
  private ingredientUrl = 'http://localhost:8080/api/ingredient';
  private findIngredientsUrl = 'http://localhost:8080/api/ingredient/find'

  getHttpIngredient() {
    let i = this.http.get(this.ingredientUrl);
    return i;
  }

  getIngredientsById(id : number){
    let url = this.ingredientRecipeUrl.concat(id.toString())
    return this.http.get(url)
  }
  
  searchIngredientBySubStr(subStr : string){
    let params = new HttpParams().set("ingredientNameSubStr",subStr)
    let i = this.http.get(this.findIngredientsUrl, {params: params});
    
    console.log(i);
    return i; 
  }
/*
  searchIngredientBySubStr(subStr : string){
    
    this.ingredientUrl.concat(subStr);
    this.filtered = []
    for (let item of INGREDIENTS) {
      if (item.ingredientName.includes(subStr)) {
          this.filtered.push(item)
      }
  }  
    return this.filtered;
  }
*/
  constructor(private http: HttpClient) { }

  
}
