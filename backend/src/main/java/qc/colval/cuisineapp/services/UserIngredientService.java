package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.entities.User;
import qc.colval.cuisineapp.models.entities.UserIngredient;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.entities.id_classes.UserIngredientId;
import qc.colval.cuisineapp.repositories.IUserIngredientRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserIngredientService {
    private final IUserIngredientRepository repos;

    public Optional<UserIngredient> findById(UserIngredientId id){
        return repos.findById(id);
    }

    public List<UserIngredient> findUserIngredientByUser(Integer userId){ return repos.findUserIngredientByUser(userId);}

    public UserIngredient save(UserIngredient userIngredient){ return repos.save(userIngredient); }

    public void deleteById(UserIngredientId userIngredientId){ repos.deleteById(userIngredientId); }
}
