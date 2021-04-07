package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
}
