package models.entities.id_classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.entities.Ingredient;
import models.entities.User;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserIngredientId implements Serializable {
    private User user;
    private Ingredient ingredient;
}
