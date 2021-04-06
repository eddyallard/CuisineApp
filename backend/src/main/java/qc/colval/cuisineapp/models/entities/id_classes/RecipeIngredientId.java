package qc.colval.cuisineapp.models.entities.id_classes;

import lombok.*;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.models.entities.Recipe;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecipeIngredientId implements Serializable {
    private Recipe recipe;
    private Ingredient ingredient;
}
