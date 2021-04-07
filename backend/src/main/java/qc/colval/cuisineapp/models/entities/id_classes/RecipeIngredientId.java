package qc.colval.cuisineapp.models.entities.id_classes;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecipeIngredientId implements Serializable {
    private Integer ingredientId;
    private Integer recipeId;
}
