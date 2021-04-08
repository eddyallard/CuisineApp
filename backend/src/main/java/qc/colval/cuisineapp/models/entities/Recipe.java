package qc.colval.cuisineapp.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "Recipe")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedQueries({
                @NamedQuery(name = "Recipe.findByRecipeNameSubStr", query = "SELECT r FROM Recipe r WHERE UPPER(substring(r.recipeName, 1, length(:recipeNameSubStr))) = UPPER(:recipeNameSubStr)")
})
public class Recipe implements Serializable {
    @Id
    @Column(name = "RecipeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer recipeId;

    @Column(name = "RecipeName")
    @Size(min = 2, max = 50)
    @NotNull
    private String recipeName;

    @Column(name = "RecipeInstruction")
    @Size(min = 2, max = 1000)
    @NotNull
    private String recipeInstruction;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull
    private User author;
}
