package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.dto.RecipeDTO;
import qc.colval.cuisineapp.models.entities.Recipe;
import qc.colval.cuisineapp.services.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeMapper implements EntityMapper<Recipe, RecipeDTO>{
    private final RecipeService recipeService;
    private final VoteService voteService;
    private final RecipeIngredientService recipeIngredientService;
    private final UserService userService;
    private final IngredientService ingredientService;

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
        return null;
    }
}
