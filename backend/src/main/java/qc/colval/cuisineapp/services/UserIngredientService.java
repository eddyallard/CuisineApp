package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.entities.UserIngredient;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IUserIngredientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserIngredientService {
    private final IUserIngredientRepository repos;

    public List<UserIngredient> findByUserId(Integer id){
        return repos.findByUserId(id);
    }
}
