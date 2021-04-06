package models.entities;

import lombok.*;
import models.entities.id_classes.RecipeIngredientId;

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
    @ManyToOne
    @JoinColumn(name = "IngredientId", referencedColumnName = "IngredientId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Ingredient ingredient;

    @Id
    @ManyToOne
    @JoinColumn(name = "RecipeId", referencedColumnName = "RecipeId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Recipe recipe;

    @Column(name = "Quantity")
    private Float quantity;
}
