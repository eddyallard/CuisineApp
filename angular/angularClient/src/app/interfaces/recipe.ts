export class Recipe {
    constructor(
        public Id: number,
        public RecipeName: string,
        public Instruction: string,
        public Ingredients: string[],
      ) {  }
    
  }