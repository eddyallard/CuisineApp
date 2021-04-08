package qc.colval.cuisineapp.models.entities;

import lombok.*;
import qc.colval.cuisineapp.models.entities.id_classes.RecipeIngredientId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "RecipeIngredient")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(RecipeIngredientId.class)
public class RecipeIngredient implements Serializable {
    @Id
    @NotNull
    private Integer ingredientId;

    @Id
    @NotNull
    private Integer recipeId;

    @Column(name = "Quantity")
    @NotNull
    private Float quantity;
}
