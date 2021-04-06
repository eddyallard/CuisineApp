package models.entities.id_classes;

import models.entities.Ingredient;
import models.entities.Recipe;

import java.io.Serializable;

public class RecipeIngredientId implements Serializable {
    private Recipe recipe;
    private Ingredient ingredient;
}
