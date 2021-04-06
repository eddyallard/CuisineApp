package models.entities.id_classes;

import models.entities.Ingredient;
import models.entities.User;

import java.io.Serializable;

public class UserIngredientId implements Serializable {
    private User user;
    private Ingredient ingredient;
}
