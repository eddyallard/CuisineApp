package repositories;

import models.entities.Recipe;
import models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findByAuthorId(Integer Id);
}
