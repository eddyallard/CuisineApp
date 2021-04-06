package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.dto.UserDTO;
import qc.colval.cuisineapp.models.entities.User;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.services.RecipeService;
import qc.colval.cuisineapp.services.UserIngredientService;
import qc.colval.cuisineapp.services.VoteService;

@Service
@AllArgsConstructor
public class UserMapper implements EntityMapper<User, UserDTO> {
    private final RecipeService recipeService;
    private final VoteService voteService;
    private final UserIngredientService userIngredientService;
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
                userDTO.getUserPassword(),
                voteService.findByUserId(userDTO.getUserId()),
                recipeService.findByAuthorId(userDTO.getUserId()),
                userIngredientService.findByUserId(userDTO.getUserId())
        );
    }
}
