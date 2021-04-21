package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.dto.RecipeIngredientDTO;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;


@Service
@AllArgsConstructor
public class RecipeIngredientMapper implements EntityMapper<RecipeIngredient, RecipeIngredientDTO> {
    @Override
    public RecipeIngredientDTO entityToDto(RecipeIngredient entity) {
        return new RecipeIngredientDTO(
                entity.getIngredientId(),
                entity.getRecipeId(),
                entity.getQuantity()
        );
    }

    @Override
    public RecipeIngredient dtoToEntity(RecipeIngredientDTO recipeIngredientDTO) {
        return new RecipeIngredient(
                recipeIngredientDTO.getIngredientId(),
                recipeIngredientDTO.getRecipeId(),
                recipeIngredientDTO.getQuantity()
        );
    }
}
