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
  quantitiesList: number[] = [];

  text = new FormControl('');

  constructor(private recipeService : RecipeService, private ingredientService : IngredientService) { }

  ngOnInit(): void {
    this.getIngredient();
  }

  getIngredient(): void {
    this.ingredientService.getHttpIngredient().subscribe((data: Ingredient[])=>{
      console.log(data);
      this.ingredients = data;
    })  
  }

  OnSearchChange() : void{
    this.filteredIngredient = this.ingredients;
    this.ingredientService.searchIngredientBySubStr(this.text.value).subscribe((data: Ingredient[])=>{
      console.log(data);
      this.filteredIngredient = data;
    })  
  }

  PostRecipe(): void {
    this.recipeService.postRecipe(this.model,this.ingredientList,this.quantitiesList, 2);
  }

  AddIngredient(ing: Ingredient): void {
      this.ingredientList.push(ing);
      this.text.setValue("");
  }

  DeleteIngredient(index: number) : void{
    this.ingredientList.splice(index, 1)
    this.quantitiesList.splice(index,)
  }

}
