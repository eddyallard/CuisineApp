package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.entities.Recipe;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IRecipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {
    private final IRecipeRepository repos;

    public List<Recipe> findByAuthorId(Integer id){
        return repos.findByAuthorId(id);
    }
}
