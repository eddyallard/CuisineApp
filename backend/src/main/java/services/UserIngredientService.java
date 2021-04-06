package services;

import lombok.AllArgsConstructor;
import models.entities.User;
import models.entities.UserIngredient;
import org.springframework.stereotype.Service;
import repositories.IUserIngredientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserIngredientService {
    private final IUserIngredientRepository repos;

    List<UserIngredient> findByUser(Integer id){
        return repos.findByUserId(id);
    }
}
