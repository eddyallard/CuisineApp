import { Component, OnInit } from '@angular/core';
import {APIRecipe} from '../interfaces/apiRecipe';
import {RecipeService} from '../recipe.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Ingredient, MeasureType } from '../interfaces/Ingredient';
import { IngredientService } from '../ingredient.service';
import {Router} from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { VoteService } from '../vote.service';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})

export class RecipeDetailComponent implements OnInit {

  recipe: APIRecipe = new APIRecipe(0,"Placeholder","Placeholder", 0);
  ingredients: Ingredient[] = [];
  quantities: number[] = [];
  voteVal: number = 0
  userVoteVal: number = 0
  userId: number = 0

  upToggled: boolean = false
  downToggled: boolean = false
  opened: Boolean = true;

  constructor(
    private recipeService : RecipeService,
    private location: Location,
    private activatedRoute: ActivatedRoute,
    private ingredientService: IngredientService,
    private voteService : VoteService,
    private auth : AuthService,
    private router: Router
    ) { }

  getRecipe(): void {
    const id = +this.activatedRoute.snapshot.paramMap.get('id');
    this.recipeService.getRecipeById(id).subscribe((data: APIRecipe)=>{
      this.recipe = data;
      this.getIngredients(this.recipe.recipeId);
      this.getVotes()
    })  
  }

  getIngredients(id : number): void{
    this.ingredientService.getIngredientsById(id).subscribe((data)=>{
    let length = Object.keys(data).length;
    let ingredientList = [];
    let quantities = [];

    console.log(data);
    for (let i = 0; i < length; i++) {
      let ingId = data[i]["ingredientDTO"]["ingredientId"];
      let ingName = data[i]["ingredientDTO"]["ingredientName"];
      let ingMea = data[i]["ingredientDTO"]["measureType"];
      ingredientList.push(new Ingredient( ingId, ingName, ingMea ));

      let qty = data[i]["quantity"];
      quantities.push(qty);
    }
    let metaList = [] 
    metaList.push(ingredientList);
    metaList.push(quantities);
    console.log(metaList);
    this.ingredients = metaList[0];
    this.quantities = metaList[1];
    });
  }
  upvote(): void {
    this.upToggled = true
    this.downToggled = false
    this.voteService.addVote(1,this.recipe.recipeId)
    if (this.userVoteVal != 1){
      this.voteVal += 1
      this.userVoteVal = 1
    }
    
  }

  downvote(): void {
    this.upToggled = false
    this.downToggled = true
    this.voteService.addVote(-1,this.recipe.recipeId)
    if (this.userVoteVal != -1){
      this.voteVal -= 1
      this.userVoteVal = -1
    }
  }

  getVotes():void {
    this.auth.getCurrentUserId().subscribe((data)=>{
      let id = data["userId"]
      console.log(this.recipe.recipeId)
      this.voteService.getVotesFromRecipe(this.recipe.recipeId).subscribe((data)=>{
        let length = Object.keys(data).length;
  
        for (let i = 0; i < length; i++){
          this.voteVal += data[i]["voteValue"]
          console.log(data[i]["voteValue"])
          if (data[i]["userId"] == id){
            this.userVoteVal = data[i]["voteValue"]
            if (this.userVoteVal == 1){
              this.upToggled = true
              this.downToggled = false
            }
            else if (this.userVoteVal == -1){
              this.upToggled = false
              this.downToggled = true
            }
            else{
              this.upToggled = false
              this.downToggled = false
            }
          }
        }
      })
    })
  }

  deleteRecipe(): void{
    this.recipeService.deleteRecipe(this.recipe);
    this.router.navigateByUrl('recipes/all');
  }

  ngOnInit(): void {
    this.getRecipe();
  }

}
