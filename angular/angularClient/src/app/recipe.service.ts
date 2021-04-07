import { Injectable } from '@angular/core';
import {Recipe} from './interfaces/recipe';
import {RECIPES} from './Mock/MockRecipe'

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor() { }

  getRecipe(): Recipe[] {
    return RECIPES;
  }

  getRecipeById(id: number): Recipe{
   return RECIPES[id];
  }
}
