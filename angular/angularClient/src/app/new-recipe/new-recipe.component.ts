import { Component, OnInit } from '@angular/core';
import { fromEventPattern } from 'rxjs';
import {RecipeService} from '../recipe.service';
import {Recipe} from '../interfaces/recipe';
import {Ingredient} from '../interfaces/Ingredient';
import {IngredientService} from '../ingredient.service'


@Component({
  selector: 'app-new-recipe',
  templateUrl: './new-recipe.component.html',
  styleUrls: ['./new-recipe.component.css']
})
export class NewRecipeComponent implements OnInit {

  model = new Recipe(69420, '', '', []);
  ingredients : Ingredient[] = [];
  filteredIngredient : Ingredient[];
  searchQuerry : string = "";
  ingredientView = false;
  
  constructor(private recipeService : RecipeService, private ingredientService : IngredientService) { }

  OnSearchChange() : void{
    this.filteredIngredient = this.ingredientService.searchIngredientBySubStr(this.searchQuerry)
  }

  WriteRecipe(): void {
    this.recipeService.postRecipe(this.model);
  }
  ngOnInit(): void {
    this.ingredients = this.ingredientService.getIngredient();
    this.filteredIngredient = this.ingredients;
  }

}
