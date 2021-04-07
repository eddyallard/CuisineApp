package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.combined.RecipeAndRecipeIngredientDTO;
import qc.colval.cuisineapp.models.dto.RecipeDTO;
import qc.colval.cuisineapp.models.dto.RecipeIngredientDTO;
import qc.colval.cuisineapp.models.entities.Recipe;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;
import qc.colval.cuisineapp.services.RecipeIngredientService;
import qc.colval.cuisineapp.services.RecipeService;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeIngredientService recipeIngredientService;
    private final EntityMapper<Recipe, RecipeDTO> recipeMapper;
    private final EntityMapper<RecipeIngredient, RecipeIngredientDTO> recipeIngredientMapper;

    @PostMapping
    public void addRecipe(@RequestBody RecipeAndRecipeIngredientDTO dto){
        dto.getRecipeDTO().setRecipeId(null);
        Recipe newRecipe = recipeService.addRecipe(recipeMapper.dtoToEntity(dto.getRecipeDTO()));
        dto.getRecipeIngredientDTOs().forEach(recipeIngredientDTO -> {
            recipeIngredientDTO.setRecipeId(newRecipe.getRecipeId());
            recipeIngredientService.addRecipeIngredient(recipeIngredientMapper.dtoToEntity(recipeIngredientDTO));
        });
    }
}
