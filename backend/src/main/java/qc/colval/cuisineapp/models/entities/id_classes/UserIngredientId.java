package qc.colval.cuisineapp.models.entities.id_classes;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserIngredientId implements Serializable {
    private Integer userId;
    private Integer ingredientId;
}
