import { Component, OnInit } from '@angular/core';
import {Recipe} from '../interfaces/recipe'

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {

  recipe: Recipe = {
    Id : 1,
    RecipeName: "Cooked water",
    Instruction: "Put the water in a large saucepan and let it simmer until you see bubbles start to form",
    Ingredients: ["250ml of water","15 ton of salt"]
  }

  constructor() { }

  ngOnInit(): void {
  }

}
