export class Ingredient {
    constructor(
        public ingredientId: number,
        public ingredientName: string,
        public measureType: MeasureType
      ) {  }
    }
 export enum MeasureType {
    ml = "ml.",
    g = "g.",
    unit = "unit"
}