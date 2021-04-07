package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.entities.Recipe;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IRecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeService {
    private final IRecipeRepository repos;

    public Optional<Recipe> findById(Integer id){
        return repos.findById(id);
    }

    public Recipe addRecipe(Recipe recipe){
        return repos.save(recipe);
    }
}
