import { Component, OnInit } from '@angular/core';
import {Recipe} from '../interfaces/recipe';
import {RecipeService} from '../recipe.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {

  recipe: Recipe = null;
  constructor(
    private recipeService : RecipeService,
    private location: Location,
    private activatedRoute: ActivatedRoute
    ) { }

  getRecipe(): void {
    const id = +this.activatedRoute.snapshot.paramMap.get('id');
    this.recipe = this.recipeService.getRecipeById(id);
  }

  ngOnInit(): void {
    this.getRecipe();
  }

}
