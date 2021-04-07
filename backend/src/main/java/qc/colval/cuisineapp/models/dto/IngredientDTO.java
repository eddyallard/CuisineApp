package qc.colval.cuisineapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientDTO {
    private Integer ingredientId;
    private String ingredientName;
    private String measureType;
    private List<Integer> recipeIds;
}
