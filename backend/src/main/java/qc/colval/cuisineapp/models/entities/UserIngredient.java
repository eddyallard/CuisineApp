package qc.colval.cuisineapp.models.entities;

import lombok.*;
import qc.colval.cuisineapp.models.entities.id_classes.UserIngredientId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "UserIngredient")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(UserIngredientId.class)
public class UserIngredient implements Serializable {
    @Id
    @NotNull
    private Integer ingredientId;

    @Id
    @NotNull
    private Integer userId;

    @Column(name = "Quantity")
    @NotNull
    private Float quantity;
}
