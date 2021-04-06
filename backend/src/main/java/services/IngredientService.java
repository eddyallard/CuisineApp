package services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.IIngredientRepository;

@Service
@AllArgsConstructor
public class IngredientService {
    private final IIngredientRepository repos;
}
