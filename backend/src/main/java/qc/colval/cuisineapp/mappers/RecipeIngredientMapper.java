package qc.colval.cuisineapp.mappers;

import qc.colval.cuisineapp.models.dto.RecipeIngredientDTO;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;

public class RecipeIngredientMapper implements EntityMapper<RecipeIngredient, RecipeIngredientDTO> {
    @Override
    public RecipeIngredientDTO entityToDto(RecipeIngredient entity) {
        return null;
    }

    @Override
    public RecipeIngredient dtoToEntity(RecipeIngredientDTO recipeIngredientDTO) {
        return null;
    }
}
