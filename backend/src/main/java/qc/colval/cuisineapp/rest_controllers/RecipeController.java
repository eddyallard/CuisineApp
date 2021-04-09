package qc.colval.cuisineapp.rest_controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.IngredientDTO;
import qc.colval.cuisineapp.models.dto.RecipeDTO;
import qc.colval.cuisineapp.models.dto.RecipeIngredientDTO;
import qc.colval.cuisineapp.models.dto.combined.IngredientQuantityDTO;
import qc.colval.cuisineapp.models.dto.combined.RecipeVoteCountDTO;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.models.entities.Recipe;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;
import qc.colval.cuisineapp.models.entities.id_classes.RecipeIngredientId;
import qc.colval.cuisineapp.services.IngredientService;
import qc.colval.cuisineapp.services.RecipeIngredientService;
import qc.colval.cuisineapp.services.RecipeService;
import qc.colval.cuisineapp.services.VoteService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RecipeController {
    private final IngredientService ingredientService;
    private final RecipeService recipeService;
    private final RecipeIngredientService recipeIngredientService;
    private final VoteService voteService;
    private final EntityMapper<Recipe, RecipeDTO> recipeMapper;
    private final EntityMapper<RecipeIngredient, RecipeIngredientDTO> recipeIngredientMapper;
    private final EntityMapper<Ingredient, IngredientDTO> ingredientMapper;

    //GET MAPPINGS
    @GetMapping("/{id}")
    public RecipeDTO getRecipeWithId(@PathVariable Integer id){
        return recipeMapper.entityToDto(recipeService.findById(id).orElse(null));
    }

    @GetMapping List<RecipeDTO> allRecipes(){
        return recipeService.findAll().stream().map(recipeMapper::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/find")
    public List<RecipeDTO> findRecipesByNameSubStr(@RequestBody Map<String, String> recipeNameSubStr){
        return recipeService.findByRecipeNameSubStr(recipeNameSubStr.get("recipeNameSubStr")).stream().map(recipeMapper::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/ingredient/{recipeId}")
    public List<IngredientQuantityDTO> findIngredientsByRecipe(@PathVariable Integer recipeId){
        List<IngredientQuantityDTO> ingredientQuantities = new ArrayList<>();
        recipeIngredientService.findRecipeIngredientForRecipeId(recipeId).forEach( recipeIngredient -> {
            ingredientQuantities.add(new IngredientQuantityDTO(
                    ingredientMapper.entityToDto(ingredientService.findById(recipeIngredient.getIngredientId()).orElse(null)),
                    recipeIngredient.getQuantity()));
        });
        return ingredientQuantities;
    }

    @GetMapping("/sorted_by_vote_with_vote_count")
    public List<RecipeVoteCountDTO> findAllRecipesSortedByVoteWithVoteCount(){
        List<RecipeVoteCountDTO> recipes = new ArrayList<>();
        //We want to reverse descending that's why we negate the result.
        Comparator<RecipeVoteCountDTO> compareByVoteCount = (o1, o2) -> -(o1.getVoteCount().compareTo(o2.getVoteCount()));
        recipeService.findAll().forEach(recipe -> {
            Integer voteCount =  voteService.getVoteCountByRecipeId(recipe.getRecipeId());
            if (voteCount == null) voteCount = 0;
            recipes.add(new RecipeVoteCountDTO(recipeMapper.entityToDto(recipe), voteCount));

        });
        recipes.sort(compareByVoteCount);
        return recipes;
    }
    //POST MAPPINGS
    @PostMapping
    public RecipeDTO addRecipe(@RequestBody RecipeDTO recipeDTO){
        recipeDTO.setRecipeId(null);
        return recipeMapper.entityToDto(recipeService.save(recipeMapper.dtoToEntity(recipeDTO)));
    }

    @PostMapping("/ingredient")
    public RecipeIngredientDTO addRecipeIngredient(@RequestBody RecipeIngredientDTO recipeIngredientDTO){
        return recipeIngredientMapper.entityToDto(recipeIngredientService.save(recipeIngredientMapper.dtoToEntity(recipeIngredientDTO)));
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
