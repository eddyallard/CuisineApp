import { Component, OnInit } from '@angular/core';
import {APIRecipe} from '../interfaces/apiRecipe';
import {RecipeService} from '../recipe.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Ingredient } from '../interfaces/Ingredient';
import { IngredientService } from '../ingredient.service';


@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})

export class RecipeDetailComponent implements OnInit {

  recipe: APIRecipe = new APIRecipe(0,"Placeholder","Placeholder", 0);
  ingredients: Ingredient[] = [];
  constructor(
    private recipeService : RecipeService,
    private location: Location,
    private activatedRoute: ActivatedRoute,
    private ingredientService: IngredientService
    ) { }

  getRecipe(): void {
    const id = +this.activatedRoute.snapshot.paramMap.get('id');
    this.recipeService.getRecipeById(id).subscribe((data: APIRecipe)=>{
      this.recipe = data;
      this.getIngredients(this.recipe.recipeId);
    })  
  }

  getIngredients(id : number): void{
    this.ingredientService.getIngredientsById(id).subscribe((data: Object[])=>{
      console.log(data);
      
    });
  }

  ngOnInit(): void {
    this.getRecipe();
  }

}
