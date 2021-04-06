import { Component, OnInit } from '@angular/core';
import {Recipe} from '../Interface/recipe'
import {Vote} from '../Interface/vote'

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {

  recipe: Recipe = {
    Id : 1,
    RecipeName: "Cooked water",
    Instruction: "Put the water in a large saucepan and let it simmer until you see bubbles start to form",
    Ingredients: ["250ml of water","15 ton of salt"]
  }

  upvotes: Vote = {
      Id: 1,
      VoteValue: 69420
  }
  constructor() { }

  ngOnInit(): void {
  }

}
