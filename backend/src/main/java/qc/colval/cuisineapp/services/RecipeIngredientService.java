package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IRecipeIngredientRepository;

@Service
@AllArgsConstructor
public class RecipeIngredientService {
    private final IRecipeIngredientRepository repos;
}
