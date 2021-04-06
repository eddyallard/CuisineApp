package repositories;

import models.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {
}
