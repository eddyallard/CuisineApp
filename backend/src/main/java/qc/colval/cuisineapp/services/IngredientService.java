package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IIngredientRepository;

@Service
@AllArgsConstructor
public class IngredientService {
    private final IIngredientRepository repos;
}
