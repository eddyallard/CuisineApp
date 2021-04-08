package qc.colval.cuisineapp.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedQueries({
        @NamedQuery(name = "Ingredient.findByIngredientNameSubStr", query = "SELECT i FROM Ingredient i WHERE UPPER(substring(i.ingredientName, 1, length(:ingredientNameSubStr))) = UPPER(:ingredientNameSubStr)")
})
public class Ingredient implements Serializable {
    @Id
    @Column(name = "IngredientId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer ingredientId;

    @Column(name = "IngredientName")
    @Size(min = 2, max = 50)
    @NotNull
    private String ingredientName;

    @Column(name = "measureType")
    @NotNull
    private String measureType;
}
