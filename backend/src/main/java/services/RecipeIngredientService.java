package services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.IRecipeIngredientRepository;

@Service
@AllArgsConstructor
public class RecipeIngredientService {
    private final IRecipeIngredientRepository repos;
}
