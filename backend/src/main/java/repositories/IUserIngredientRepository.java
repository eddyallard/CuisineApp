package repositories;

import models.entities.User;
import models.entities.UserIngredient;
import models.entities.id_classes.UserIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserIngredientRepository extends JpaRepository<UserIngredient, UserIngredientId> {
    List<UserIngredient> findByUserId(Integer Id);
}
