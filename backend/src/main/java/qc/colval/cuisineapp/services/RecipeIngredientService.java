package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;
import qc.colval.cuisineapp.models.entities.id_classes.RecipeIngredientId;
import qc.colval.cuisineapp.repositories.IRecipeIngredientRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeIngredientService {
    private final IRecipeIngredientRepository repos;

    public Optional<RecipeIngredient> findById(RecipeIngredientId id){
        return repos.findById(id);
    }

    public List<RecipeIngredient> findRecipeIngredientForRecipeId(Integer recipeId){
        return repos.findRecipeIngredientForRecipeId(recipeId);
    };

    public RecipeIngredient save(RecipeIngredient recipeIngredient){
        return repos.save(recipeIngredient);
    }

    public void deleteById(RecipeIngredientId id){
        repos.deleteById(id);
    }
}
