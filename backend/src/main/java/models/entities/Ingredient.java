package models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ingredient implements Serializable {
    @Id
    @Column(name = "IngredientId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingredientId;

    @Column(name = "IngredientName")
    @Size(min = 2, max = 50)
    private String ingredientName;

    @Column(name = "measureType")
    private String measureType;

    @OneToMany(mappedBy = "ingredient")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RecipeIngredient> recipes;
}
