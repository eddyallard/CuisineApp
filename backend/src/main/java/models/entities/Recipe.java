package models.entities;

import lombok.*;

import javax.persistence.*;
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
    private String recipeName;

    @Column(name = "RecipeInstruction")
    private String recipeInstruction;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User author;

    @OneToMany(mappedBy = "recipe")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vote> votes;

    @OneToMany(mappedBy = "recipe")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RecipeIngredient> ingredients;
}
