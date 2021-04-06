package services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.IUserIngredientRepository;

@Service
@AllArgsConstructor
public class UserIngredientService {
    private final IUserIngredientRepository repos;
}
