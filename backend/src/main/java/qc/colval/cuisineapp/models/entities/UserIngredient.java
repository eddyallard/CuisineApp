package qc.colval.cuisineapp.models.entities;

import lombok.*;
import qc.colval.cuisineapp.models.entities.id_classes.UserIngredientId;

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
    private Integer ingredientId;

    @Id
    private Integer userId;

    @Column(name = "Quantity")
    private Float quantity;
}
