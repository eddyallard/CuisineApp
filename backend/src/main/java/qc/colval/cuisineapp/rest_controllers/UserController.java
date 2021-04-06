package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.UserDTO;
import qc.colval.cuisineapp.models.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qc.colval.cuisineapp.services.UserService;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final EntityMapper<User, UserDTO> mapper;

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(mapper.dtoToEntity(userDTO));
    }
}
