package repositories;

import models.entities.UserIngredient;
import models.entities.id_classes.UserIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserIngredientRepository extends JpaRepository<UserIngredient, UserIngredientId> {
}
