package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.models.entities.RecipeIngredient;
import qc.colval.cuisineapp.repositories.IRecipeIngredientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeIngredientService {
    private final IRecipeIngredientRepository repos;

    public RecipeIngredient save(RecipeIngredient recipeIngredient){
        return repos.save(recipeIngredient);
    }
}
