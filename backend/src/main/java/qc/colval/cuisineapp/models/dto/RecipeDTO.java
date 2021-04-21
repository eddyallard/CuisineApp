package qc.colval.cuisineapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeDTO {
    private Integer recipeId;
    private String recipeName;
    private String recipeInstruction;
    private Integer authorId;
}
