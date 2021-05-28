import { Component, OnInit } from '@angular/core';
import {RecipeService} from '../recipe.service';
import {APIRecipe} from '../interfaces/apiRecipe';
import { MatDialog } from '@angular/material/dialog';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  recipes: APIRecipe[] = [];

  loading : Boolean = true;

  constructor(private recipeService : RecipeService, private auth: AuthService, private router: Router) { }


  getRecipes(): void {
    this.recipeService.getRecipe().subscribe((data: APIRecipe[])=>{
      this.recipes = data;
      this.loading = false;
    })
  }  

  ngOnInit(): void {
  
    if (!this.auth.isAuthenticated()){
      this.router.navigate(['/login'])
    }
    else{
      this.getRecipes();
    }
  }

  refresh(): void {
    window.location.reload();  
  }

}
