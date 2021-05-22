package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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


import javax.validation.Valid;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
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
    public ResponseEntity<RecipeDTO> getRecipeWithId(@PathVariable Integer id){
        Optional<Recipe> recipe = recipeService.findById(id);
        return recipe.map(value -> ResponseEntity.ok(recipeMapper.entityToDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping ResponseEntity<List<RecipeDTO>> allRecipes(){
        return ResponseEntity.ok(recipeService.findAll()
                .stream().map(recipeMapper::entityToDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/find")
    public ResponseEntity<List<RecipeDTO>> findRecipesByNameSubStr(@RequestParam String recipeNameSubStr){
        return ResponseEntity.ok(recipeService.findByRecipeNameSubStr(recipeNameSubStr)
                .stream().map(recipeMapper::entityToDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/ingredient/{recipeId}")
    public ResponseEntity<List<IngredientQuantityDTO>> findIngredientsByRecipe(@PathVariable Integer recipeId){
        List<IngredientQuantityDTO> ingredientQuantities = new ArrayList<>();
        recipeIngredientService.findRecipeIngredientForRecipeId(recipeId).forEach( recipeIngredient -> {
            ingredientQuantities.add(new IngredientQuantityDTO(
                    ingredientMapper.entityToDto(ingredientService.findById(recipeIngredient.getIngredientId()).orElse(null)),
                    recipeIngredient.getQuantity()));
        });
        return ResponseEntity.ok(ingredientQuantities);
    }

    @GetMapping("/sorted_by_vote_with_vote_count")
    public ResponseEntity<List<RecipeVoteCountDTO>> findAllRecipesSortedByVoteWithVoteCount(){
        List<RecipeVoteCountDTO> recipes = new ArrayList<>();
        //We want to reverse descending that's why we negate the result.
        Comparator<RecipeVoteCountDTO> compareByVoteCount = (o1, o2) -> -(o1.getVoteCount().compareTo(o2.getVoteCount()));
        recipeService.findAll().forEach(recipe -> {
            Integer voteCount =  voteService.getVoteCountByRecipeId(recipe.getRecipeId());
            if (voteCount == null) voteCount = 0;
            recipes.add(new RecipeVoteCountDTO(recipeMapper.entityToDto(recipe), voteCount));

        });
        recipes.sort(compareByVoteCount);
        return ResponseEntity.ok(recipes);
    }
    //POST MAPPINGS
    @PostMapping
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody @Valid RecipeDTO recipeDTO){
        recipeDTO.setRecipeId(null);
        Recipe saved = recipeService.save(recipeMapper.dtoToEntity(recipeDTO));
        return ResponseEntity.created(URI.create(saved.getRecipeId().toString()))
                .body(recipeMapper.entityToDto(saved));
    }

    @PostMapping("/ingredient")
    public ResponseEntity<RecipeIngredientDTO> addRecipeIngredient(@RequestBody @Valid RecipeIngredientDTO recipeIngredientDTO){
        RecipeIngredient saved = recipeIngredientService.save(recipeIngredientMapper.dtoToEntity(recipeIngredientDTO));
        return ResponseEntity.created(URI.create(saved.getIngredientId().toString() + '_' + saved.getRecipeId().toString()))
                .body(recipeIngredientMapper.entityToDto(saved));
    }

    //PUT MAPPINGS
    @PutMapping ("/name/{id}")
    public ResponseEntity<RecipeDTO> editRecipeName(@PathVariable Integer id, @RequestBody Map<String, String> newName){
        Optional<Recipe> recipe = recipeService.findById(id);
        recipe.ifPresent(value -> value.setRecipeName(newName.get("newName")));
        return recipe.map(value -> ResponseEntity.ok(recipeMapper.entityToDto(recipeService.save(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping ("/instruction/{id}")
    public ResponseEntity<RecipeDTO> editRecipeInstruction(@PathVariable Integer id, @RequestBody Map<String, String> newInstruction){
        Optional<Recipe> recipe = recipeService.findById(id);
        recipe.ifPresent(value -> value.setRecipeInstruction(newInstruction.get("newInstruction")));
        return recipe.map(value -> ResponseEntity.ok(recipeMapper.entityToDto(recipeService.save(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/ingredient/")
    public ResponseEntity<RecipeIngredientDTO> editIngredientQuantity(@RequestBody RecipeIngredientDTO recipeIngredientDTO){
        Optional<RecipeIngredient> recipeIngredient = recipeIngredientService.findById(
                new RecipeIngredientId(
                        recipeIngredientDTO.getIngredientId(),
                        recipeIngredientDTO.getRecipeId()));
        recipeIngredient.ifPresent(value -> value.setQuantity(recipeIngredientDTO.getQuantity()));
        return recipeIngredient.map(value -> ResponseEntity.ok(recipeIngredientMapper.entityToDto(recipeIngredientService.save(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //DELETE MAPPINGS
    @DeleteMapping("/ingredient")
    public ResponseEntity<String> deleteIngredient(@RequestParam Integer recipeId, @RequestParam Integer ingredientId){
        recipeIngredientService.deleteById(new RecipeIngredientId(ingredientId, recipeId));
        return ResponseEntity.ok("Recipe Ingredient Deleted Successfully");
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Integer recipeId){
        recipeService.deleteById(recipeId);
        return ResponseEntity.ok("Recipe Deleted Successfully");
    }
}
