export class Ingredient {
    constructor(
        public ingredient : Ingredient,
        public quantity : number
      ) {  }
    }
 export enum MeasureType {
    ml = "ml.",
    g = "g.",
    unit = "unit"
}