import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SSL_OP_SSLEAY_080_CLIENT_DH_BUG } from 'node:constants';
import { count } from 'rxjs/operators';
import { Ingredient } from './interfaces/Ingredient';
import {Recipe} from './interfaces/recipe';
import {RECIPES} from './Mock/MockRecipe';
import {APIRecipe} from './interfaces/apiRecipe'
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private recipeGetUrl = 'https://cuisinas.herokuapp.com/api/recipe/';
  private recipePostUrl = 'https://cuisinas.herokuapp.com/api/recipe';
  private recipeIngredientPostUrl = 'https://cuisinas.herokuapp.com/api/recipe/ingredient';


  constructor(private http: HttpClient, private router: Router) { }

  getRecipe() {
    let i = this.http.get(this.recipePostUrl);
    return i;
  }

  getRecipeById(id: number){
   let url = this.recipeGetUrl.concat(id.toString());
   let i = this.http.get(url);
   console.log(i);
   return i;
  }

  private postRecipeEmpty (recipe: APIRecipe, author: number){
    const body = { recipeName: recipe.recipeName,
      recipeInstruction: recipe.recipeInstruction,
      authorId: author
     };
    return this.http.post(this.recipePostUrl, body);
  }

  postRecipeIngredient (ingredients : Ingredient[], id : number, quantities : number[]){
    let count = 0;
    for (let ingredient of ingredients){
      let body = 
      { recipeId: id,
        ingredientId: ingredient.ingredientId,
        quantity: quantities[count]
       };
       console.log(count);
       count++;
      this.http.post(this.recipeIngredientPostUrl,body).toPromise();
    }
  }

  postRecipe(recipe: APIRecipe, ingredients: Ingredient[], quantities: number[], author: number ){
    this.postRecipeEmpty(recipe, author).subscribe((data : APIRecipe)=>{
      console.log(data);
      this.postRecipeIngredient(ingredients, data.recipeId, quantities)
    });
    
  }

  deleteRecipe(recipe: APIRecipe){
    let url = this.recipeGetUrl +recipe.recipeId.toString();
    this.http.delete(url).toPromise();
    
    
  }
}
