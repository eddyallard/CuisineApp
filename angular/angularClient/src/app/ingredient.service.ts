import { Injectable } from '@angular/core';
import { element } from 'protractor';
import {Ingredient} from './interfaces/Ingredient'
import {INGREDIENTS} from './Mock/MockIngredient'
 
@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private filtered : Ingredient[];
  getIngredient(): Ingredient[] {
    return INGREDIENTS;
  }

  searchIngredientBySubStr(subStr : string) : Ingredient[]{
    this.filtered = []
    for (let item of INGREDIENTS) {
      if (item.IngredientName.includes(subStr)) {
          this.filtered.push(item)
      }
  }  
    return this.filtered;
  }

  constructor() { }

  
}
