package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.dto.RecipeIngredientDTO;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;
import qc.colval.cuisineapp.services.IngredientService;
import qc.colval.cuisineapp.services.RecipeService;


@Service
@AllArgsConstructor
public class RecipeIngredientMapper implements EntityMapper<RecipeIngredient, RecipeIngredientDTO> {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
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
