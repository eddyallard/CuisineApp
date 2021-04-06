package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {
}
