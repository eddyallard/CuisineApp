package qc.colval.cuisineapp.models.dto.combined;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qc.colval.cuisineapp.models.dto.RecipeDTO;
import qc.colval.cuisineapp.models.dto.RecipeIngredientDTO;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeAndRecipeIngredientDTO {
    private RecipeDTO recipeDTO;
    private List<RecipeIngredientDTO> recipeIngredientDTOs;
}
