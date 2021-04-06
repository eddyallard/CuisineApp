package models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeIngredientDTO {
    private Integer ingredientId;
    private Integer recipeId;
    private Float quantity;
}
