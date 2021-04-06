package services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.IRecipeRepository;

@Service
@AllArgsConstructor
public class RecipeService {
    private final IRecipeRepository repos;
}
