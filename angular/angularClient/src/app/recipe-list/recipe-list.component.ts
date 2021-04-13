import { Component, OnInit } from '@angular/core';
import {RecipeService} from '../recipe.service';
import {APIRecipe} from '../interfaces/apiRecipe';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: APIRecipe[] = [];

  constructor(private recipeService : RecipeService) { }

  getRecipes(): void {
    this.recipeService.getRecipe().subscribe((data: APIRecipe[])=>{
      console.log(data);
      this.recipes = data;
    })
  }  

  ngOnInit(): void {
    this.getRecipes();
  }

}
