package mappers;

import lombok.AllArgsConstructor;
import models.dto.UserDTO;
import models.entities.User;
import org.springframework.stereotype.Service;
import repositories.IRecipeRepository;
import repositories.IUserIngredientRepository;
import repositories.IVoteRepository;

@Service
@AllArgsConstructor
public class UserMapper implements EntityMapper<User, UserDTO> {
    private final IRecipeRepository recipeRepository;
    private final IVoteRepository voteRepository;
    private final IUserIngredientRepository userIngredientRepository;
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
                voteRepository.findByUserId(userDTO.getUserId()),
                recipeRepository.findByAuthorId(userDTO.getUserId()),
                userIngredientRepository.findByUserId(userDTO.getUserId())
        );
    }
}
