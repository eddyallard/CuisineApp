package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.combined.RecipeAndRecipeIngredientDTO;
import qc.colval.cuisineapp.models.dto.RecipeDTO;
import qc.colval.cuisineapp.models.dto.RecipeIngredientDTO;
import qc.colval.cuisineapp.models.entities.Recipe;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;
import qc.colval.cuisineapp.services.RecipeIngredientService;
import qc.colval.cuisineapp.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeIngredientService recipeIngredientService;
    private final EntityMapper<Recipe, RecipeDTO> recipeMapper;
    private final EntityMapper<RecipeIngredient, RecipeIngredientDTO> recipeIngredientMapper;

    @PostMapping
    public Recipe addRecipe(@RequestBody RecipeAndRecipeIngredientDTO dto){
        dto.getRecipeDTO().setRecipeId(null);
        Recipe newRecipe = recipeService.save(recipeMapper.dtoToEntity(dto.getRecipeDTO()));
        dto.getRecipeIngredientDTOs().forEach(recipeIngredientDTO -> {
            recipeIngredientDTO.setRecipeId(newRecipe.getRecipeId());
            recipeIngredientService.save(recipeIngredientMapper.dtoToEntity(recipeIngredientDTO));
        });
        return newRecipe;
    }

    @PutMapping ("/name/{id}")
    public Recipe editRecipeName(@PathVariable Integer id, @RequestBody String newName){
        Recipe recipe = recipeService.findById(id).get();
        recipe.setRecipeName(newName);
        return recipeService.save(recipe);
    }

    @PutMapping ("/instruction/{id}")
    public Recipe editRecipeInstruction(@PathVariable Integer id, @RequestBody String newInstruction){
        Recipe recipe = recipeService.findById(id).get();
        recipe.setRecipeInstruction(newInstruction);
        return recipeService.save(recipe);
    }

    @GetMapping List<Recipe> allRecipes(){
        return recipeService.findAll();
    }

    @GetMapping("/find")
    public List<Recipe> findRecipesByNameSubStr(@RequestParam String recipeNameSubStr){
        return recipeService.findByRecipeNameSubStr(recipeNameSubStr);
    }
}
