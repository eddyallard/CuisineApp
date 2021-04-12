import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SSL_OP_SSLEAY_080_CLIENT_DH_BUG } from 'node:constants';
import { count } from 'rxjs/operators';
import { Ingredient } from './interfaces/Ingredient';
import {Recipe} from './interfaces/recipe';
import {RECIPES} from './Mock/MockRecipe'

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private recipePostUrl = 'http://localhost:8080/api/recipe';
  private recipeIngredientPostUrl = 'http://localhost:8080/api/recipe/ingredient';

  constructor(private http: HttpClient) { }

  getRecipe(): Recipe[] {
    return RECIPES;
  }

  getRecipeById(id: number): Recipe{
   return RECIPES[id];
  }

  private postRecipeEmpty (recipe: Recipe, author: number){
    const body = { recipeName: recipe.RecipeName,
      recipeInstruction: recipe.Instruction,
      authorId: author
     };
    return this.http.post(this.recipePostUrl, body);
  }

  postRecipeIngredient (ingredients : Ingredient[], id : number, quantities : number[]){
    let count = 0;
    console.log(id);
    for (let ingredient of ingredients){
      const body = { recipeId: id,
        ingredientId: ingredient.ingredientId,
        quantiy: quantities[count]
       };
       count++;
      this.http.post(this.recipeIngredientPostUrl,body)
    }
  }

  postRecipe(recipe: Recipe, ingredients: Ingredient[], quantities: number[], author: number ){
    this.postRecipeEmpty(recipe, author).subscribe((data: Recipe)=>{
      this.postRecipeIngredient(ingredients, data.Id, quantities)
    });
    
  }
}
