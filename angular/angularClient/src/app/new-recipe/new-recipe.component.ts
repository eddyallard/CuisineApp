import { Component, OnInit } from '@angular/core';
import { fromEventPattern } from 'rxjs';
import {RecipeService} from '../recipe.service';
import {APIRecipe} from '../interfaces/apiRecipe';
import {Ingredient} from '../interfaces/Ingredient';
import {IngredientService} from '../ingredient.service'
import { FormControl } from '@angular/forms';
import {Router} from '@angular/router';



@Component({
  selector: 'app-new-recipe',
  templateUrl: './new-recipe.component.html',
  styleUrls: ['./new-recipe.component.css']
})
export class NewRecipeComponent implements OnInit {

  model = new APIRecipe(69420, '', '',0);
  ingredients : Ingredient[] = [];
  ingredientList : Ingredient[] = [];
  filteredIngredient : Ingredient[];
  quantitiesList: number[] = [];

  text = new FormControl('');

  events: string[] = [];
  opened: boolean;

  isHidden: boolean = true;

  shouldRun = [/(^|\.)plnkr\.co$/, /(^|\.)stackblitz\.io$/].some(h => h.test(window.location.host));

  constructor(private recipeService : RecipeService, private ingredientService : IngredientService, private router: Router) { }

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
    this.router.navigateByUrl('recipes/all');
  }

  AddIngredient(ing: Ingredient): void {
      this.ingredientList.push(ing);
      this.text.setValue("");
      this.isHidden = false;
  }

  DeleteIngredient(index: number) : void{
    this.ingredientList.splice(index, 1)
    this.quantitiesList.splice(index,)
    if (this.ingredientList.length == 0){
      this.isHidden = true;
    }
  }

}
