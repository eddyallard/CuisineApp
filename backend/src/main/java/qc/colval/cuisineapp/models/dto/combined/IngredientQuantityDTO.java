package qc.colval.cuisineapp.models.dto.combined;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qc.colval.cuisineapp.models.dto.IngredientDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientQuantityDTO {
    public IngredientDTO ingredientDTO;
    public Float quantity;
}
