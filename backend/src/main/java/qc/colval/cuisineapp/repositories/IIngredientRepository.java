package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByIngredientNameSubStr(String ingredientNameSubStr);
}
