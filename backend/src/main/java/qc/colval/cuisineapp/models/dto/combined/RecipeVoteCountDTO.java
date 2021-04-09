package qc.colval.cuisineapp.models.dto.combined;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qc.colval.cuisineapp.models.dto.RecipeDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeVoteCountDTO {
    public RecipeDTO recipeDTO;
    public Integer voteCount;
}
