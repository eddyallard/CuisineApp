package services;

import lombok.AllArgsConstructor;
import models.entities.Recipe;
import models.entities.User;
import org.springframework.stereotype.Service;
import repositories.IRecipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {
    private final IRecipeRepository repos;

    List<Recipe> findByAuthor(Integer id){
        return repos.findByAuthorId(id);
    }
}
