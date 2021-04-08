package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.dto.IngredientDTO;
import qc.colval.cuisineapp.models.entities.Ingredient;

@Service
@AllArgsConstructor
public class IngredientMapper implements EntityMapper<Ingredient, IngredientDTO> {

    @Override
    public IngredientDTO entityToDto(Ingredient entity) {
        return new IngredientDTO(
                entity.getIngredientId(),
                entity.getIngredientName(),
                entity.getMeasureType()
        );
    }

    @Override
    public Ingredient dtoToEntity(IngredientDTO ingredientDTO) {
        return new Ingredient(
                ingredientDTO.getIngredientId(),
                ingredientDTO.getIngredientName(),
                ingredientDTO.getMeasureType()
        );
    }
}
