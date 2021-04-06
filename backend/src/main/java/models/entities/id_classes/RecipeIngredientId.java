package models.entities.id_classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.entities.Ingredient;
import models.entities.Recipe;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeIngredientId implements Serializable {
    private Recipe recipe;
    private Ingredient ingredient;
}
