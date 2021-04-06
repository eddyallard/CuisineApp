package qc.colval.cuisineapp.models.entities.id_classes;

import lombok.*;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.models.entities.User;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserIngredientId implements Serializable {
    private User user;
    private Ingredient ingredient;
}
