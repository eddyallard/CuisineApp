package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.dto.UserDTO;
import qc.colval.cuisineapp.models.entities.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMapper implements EntityMapper<User, UserDTO> {
    @Override
    public UserDTO entityToDto(User entity) {
        return new UserDTO(
                entity.getUserId(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getUserPassword(),
                entity.getRoles(),
                entity.getPermissions()
        );
    }

    @Override
    public User dtoToEntity(UserDTO userDTO) {
        return new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                userDTO.getUserPassword(),
                userDTO.getRoles(),
                userDTO.getPermissions(),
                true
        );
    }
}
