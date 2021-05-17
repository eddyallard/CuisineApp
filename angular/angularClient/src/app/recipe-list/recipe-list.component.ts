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

  loading : Boolean = true;

  constructor(private recipeService : RecipeService) { }

  getRecipes(): void {
    this.recipeService.getRecipe().subscribe((data: APIRecipe[])=>{
      this.recipes = data;
      this.loading = false;
    })
  }  

  ngOnInit(): void {
    this.getRecipes();
  }

  refresh(): void {
    window.location.reload();  
  }

}
