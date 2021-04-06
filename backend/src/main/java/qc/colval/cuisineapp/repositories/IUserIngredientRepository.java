package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.UserIngredient;
import qc.colval.cuisineapp.models.entities.id_classes.UserIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserIngredientRepository extends JpaRepository<UserIngredient, UserIngredientId> {
    List<UserIngredient> findByUserId(Integer id);
}
