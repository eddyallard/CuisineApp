import { Component, OnInit } from '@angular/core';
import {RecipeService} from '../recipe.service';
import {Recipe} from '../interfaces/recipe';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[] = [];

  constructor(private recipeService : RecipeService) { }

  getRecipes(): void {
    this.recipes = this.recipeService.getRecipe();
  }

  ngOnInit(): void {
    this.getRecipes();
  }

}
