import { Injectable } from '@angular/core';
import {Ingredient} from './interfaces/Ingredient'
import {INGREDIENTS} from './Mock/MockIngredient'
 
@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  getIngredient(): Ingredient[] {
    return INGREDIENTS;
  }

  searchIngredientBySubStr(subStr : string) : Ingredient[]{
    return INGREDIENTS;
  }

  constructor() { }

  
}
