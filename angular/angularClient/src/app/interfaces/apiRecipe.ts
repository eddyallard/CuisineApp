export class APIRecipe {
    constructor(
        public recipeId: number,
        public recipeName: string,
        public recipeInstruction: string,
        public authorId: number
      ) {  }
    
  }