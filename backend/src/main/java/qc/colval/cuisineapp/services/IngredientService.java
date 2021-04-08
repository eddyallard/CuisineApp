package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.repositories.IIngredientRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IngredientService {
    private final IIngredientRepository repos;

    public Optional<Ingredient> findById(Integer id){
        return repos.findById(id);
    }

    public List<Ingredient> findIngredientByRecipeId(Integer recipeId){
        return repos.findIngredientByRecipeId(recipeId);
    }
}
