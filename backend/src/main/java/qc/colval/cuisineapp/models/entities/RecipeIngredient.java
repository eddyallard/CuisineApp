package qc.colval.cuisineapp.models.entities;

import lombok.*;
import qc.colval.cuisineapp.models.entities.id_classes.RecipeIngredientId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RecipeIngredient")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(RecipeIngredientId.class)
public class RecipeIngredient implements Serializable {
    @Id
    private Integer ingredientId;

    @Id
    private Integer recipeId;

    @Column(name = "Quantity")
    private Float quantity;
}
