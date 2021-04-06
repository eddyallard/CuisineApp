package repositories;

import models.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
}
