package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.dto.RecipeDTO;
import qc.colval.cuisineapp.models.entities.Recipe;
import qc.colval.cuisineapp.services.*;

@Service
@AllArgsConstructor
public class RecipeMapper implements EntityMapper<Recipe, RecipeDTO>{
    private final UserService userService;

    @Override
    public RecipeDTO entityToDto(Recipe entity) {
        return new RecipeDTO(
                entity.getRecipeId(),
                entity.getRecipeName(),
                entity.getRecipeInstruction(),
                entity.getAuthor().getUserId()
        );
    }

    @Override
    public Recipe dtoToEntity(RecipeDTO recipeDTO) {
        return new Recipe(
                recipeDTO.getRecipeId(),
                recipeDTO.getRecipeName(),
                recipeDTO.getRecipeInstruction(),
                userService.findById(recipeDTO.getAuthorId()).get()
        );
    }
}
