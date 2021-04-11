import { Component, OnInit } from '@angular/core';
import { fromEventPattern } from 'rxjs';
import {RecipeService} from '../recipe.service';
import {Recipe} from '../interfaces/recipe';
import {Ingredient} from '../interfaces/Ingredient';
import {IngredientService} from '../ingredient.service'
import { FormControl } from '@angular/forms';


@Component({
  selector: 'app-new-recipe',
  templateUrl: './new-recipe.component.html',
  styleUrls: ['./new-recipe.component.css']
})
export class NewRecipeComponent implements OnInit {

  model = new Recipe(69420, '', '', []);
  ingredients : Ingredient[] = [];
  ingredientList : Ingredient[] = [];
  filteredIngredient : Ingredient[];
  searchQuerry : string = "";
  quantitiesList: number[] = [];

  text = new FormControl('');
  
  constructor(private recipeService : RecipeService, private ingredientService : IngredientService) { }

  OnSearchChange() : void{
    this.filteredIngredient = this.ingredientService.searchIngredientBySubStr(this.text.value)
  }

  WriteRecipe(): void {
    this.recipeService.postRecipe(this.model);
  }
  ngOnInit(): void {
    this.ingredients = this.ingredientService.getIngredient();
    this.filteredIngredient = this.ingredients;
  }

  AddIngredient(ing: Ingredient): void {
      this.ingredientList.push(ing);
      this.text.setValue("");
  }

  DeleteIngredient(index: number) : void{
    this.ingredientList.splice(index, 1)
    this.quantitiesList.splice(index, 1)
  }

}
