package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.dto.UserIngredientDTO;
import qc.colval.cuisineapp.models.entities.UserIngredient;

@Service
@AllArgsConstructor
public class UserIngredientMapper implements EntityMapper<UserIngredient, UserIngredientDTO> {
    @Override
    public UserIngredientDTO entityToDto(UserIngredient entity) {
        return new UserIngredientDTO(
                entity.getIngredientId(),
                entity.getUserId(),
                entity.getQuantity()
        );
    }

    @Override
    public UserIngredient dtoToEntity(UserIngredientDTO userIngredientDTO) {
        return new UserIngredient(
                userIngredientDTO.getIngredientId(),
                userIngredientDTO.getUserId(),
                userIngredientDTO.getQuantity()
        );
    }
}
