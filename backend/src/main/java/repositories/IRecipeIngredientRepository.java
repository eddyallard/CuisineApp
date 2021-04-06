package repositories;

import models.entities.RecipeIngredient;
import models.entities.id_classes.RecipeIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientId> {
}
