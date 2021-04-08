export class Ingredient {
    constructor(
        public Id: number,
        public IngredientName: string,
        public measureType: MeasureType
      ) {  }
    }
 export enum MeasureType {
    ml = "ml.",
    g = "g.",
    unit = "unit."
}