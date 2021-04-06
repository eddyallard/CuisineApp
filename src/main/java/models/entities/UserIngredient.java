package models.entities;

import lombok.*;
import models.entities.id_classes.UserIngredientId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserIngredient")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(UserIngredientId.class)
public class UserIngredient implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IngredientId", referencedColumnName = "IngredientId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Ingredient ingredient;

    @Id
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @Column(name = "Quantity")
    private Float quantity;
}
