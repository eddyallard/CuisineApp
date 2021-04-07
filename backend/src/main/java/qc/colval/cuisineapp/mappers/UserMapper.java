package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.dto.UserDTO;
import qc.colval.cuisineapp.models.entities.*;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.entities.id_classes.UserIngredientId;
import qc.colval.cuisineapp.models.entities.id_classes.VoteId;
import qc.colval.cuisineapp.services.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserMapper implements EntityMapper<User, UserDTO> {
    private final RecipeService recipeService;
    private final VoteService voteService;
    private final UserIngredientService userIngredientService;
    private final UserService userService;
    private final IngredientService ingredientService;

    @Override
    public UserDTO entityToDto(User entity) {
        return new UserDTO(
                entity.getUserId(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getUserPassword()
        );
    }

    @Override
    public User dtoToEntity(UserDTO userDTO) {
        return new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                userDTO.getUserPassword()
        );
    }
}
