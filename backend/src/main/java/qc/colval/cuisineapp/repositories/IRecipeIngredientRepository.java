package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.RecipeIngredient;
import qc.colval.cuisineapp.models.entities.id_classes.RecipeIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientId> {
}
