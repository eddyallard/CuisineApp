package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.IngredientDTO;
import qc.colval.cuisineapp.models.dto.RecipeDTO;
import qc.colval.cuisineapp.models.dto.RecipeIngredientDTO;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.models.entities.Recipe;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;
import qc.colval.cuisineapp.models.entities.id_classes.RecipeIngredientId;
import qc.colval.cuisineapp.services.IngredientService;
import qc.colval.cuisineapp.services.RecipeIngredientService;
import qc.colval.cuisineapp.services.RecipeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeIngredientService recipeIngredientService;
    private final IngredientService ingredientService;
    private final EntityMapper<Recipe, RecipeDTO> recipeMapper;
    private final EntityMapper<RecipeIngredient, RecipeIngredientDTO> recipeIngredientMapper;
    private final EntityMapper<Ingredient, IngredientDTO> ingredientMapper;

    //GET MAPPINGS
    @GetMapping("/{id}")
    public Recipe getRecipeWithId(@PathVariable Integer id){
        return recipeService.findById(id).orElse(null);
    }

    @GetMapping List<Recipe> allRecipes(){
        return recipeService.findAll();
    }

    @GetMapping("/find")
    public List<Recipe> findRecipesByNameSubStr(@RequestBody Map<String, String> recipeNameSubStr){
        return recipeService.findByRecipeNameSubStr(recipeNameSubStr.get("recipeNameSubStr"));
    }

    @GetMapping("/ingredient/{recipeId}")
    public List<RecipeIngredient> findIngredientsByRecipe(@PathVariable Integer recipeId){
        return recipeIngredientService.findRecipeIngredientForRecipeId(recipeId);
    }

    //POST MAPPINGS
    @PostMapping
    public Recipe addRecipe(@RequestBody RecipeDTO recipeDTO){
        recipeDTO.setRecipeId(null);
        return recipeService.save(recipeMapper.dtoToEntity(recipeDTO));
    }

    @PostMapping("/ingredient")
    public RecipeIngredient addRecipeIngredient(@RequestBody RecipeIngredientDTO recipeIngredientDTO){
        return recipeIngredientService.save(recipeIngredientMapper.dtoToEntity(recipeIngredientDTO));
    }

    //PUT MAPPINGS
    @PutMapping ("/name/{id}")
    public Recipe editRecipeName(@PathVariable Integer id, @RequestBody Map<String, String> newName){
        Recipe recipe = recipeService.findById(id).orElse(null);
        if (recipe != null) {
            recipe.setRecipeName(newName.get("newName"));
            return recipeService.save(recipe);
        }
        return null;
    }

    @PutMapping ("/instruction/{id}")
    public Recipe editRecipeInstruction(@PathVariable Integer id, @RequestBody Map<String, String> newInstruction){
        Recipe recipe = recipeService.findById(id).orElse(null);
        if (recipe != null) {
            recipe.setRecipeInstruction(newInstruction.get("newInstruction"));
            return recipeService.save(recipe);
        }
        return null;
    }

    @PutMapping("/ingredient/")
    public RecipeIngredient editIngredientQuantity(@RequestBody RecipeIngredientDTO recipeIngredientDTO){
        RecipeIngredient recipeIngredient = recipeIngredientService.findById(
                new RecipeIngredientId(
                        recipeIngredientDTO.getIngredientId(),
                        recipeIngredientDTO.getRecipeId()))
                .orElse(null);
        if (recipeIngredient != null){
            recipeIngredient.setQuantity(recipeIngredientDTO.getQuantity());
            return recipeIngredientService.save(recipeIngredient);
        }
        return null;
    }

    //DELETE MAPPINGS
    @DeleteMapping("/ingredient/{recipeId}/{ingredientId}")
    public String deleteIngredient(@PathVariable Integer recipeId, @PathVariable Integer ingredientId){
        recipeIngredientService.deleteById(new RecipeIngredientId(ingredientId, recipeId));
        return "Ingredient Deleted Successfully";
    }

    @DeleteMapping("/ingredient/{recipeId}")
    public String deleteRecipe(@PathVariable Integer recipeId){
        recipeService.deleteById(recipeId);
        return "Recipe Deleted Successfully";
    }
}
