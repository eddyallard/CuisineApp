package qc.colval.cuisineapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserIngredientDTO {
    private Integer ingredientId;
    private Integer userId;
    private Float quantity;
}
