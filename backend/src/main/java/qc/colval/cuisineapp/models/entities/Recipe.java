package qc.colval.cuisineapp.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Recipe")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Recipe implements Serializable {
    @Id
    @Column(name = "RecipeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;

    @Column(name = "RecipeName")
    @Size(min = 2, max = 50)
    private String recipeName;

    @Column(name = "RecipeInstruction")
    @Size(min = 2, max = 1000)
    private String recipeInstruction;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User author;
}
