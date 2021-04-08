package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.UserDTO;
import qc.colval.cuisineapp.models.dto.UserIngredientDTO;
import qc.colval.cuisineapp.models.entities.User;
import qc.colval.cuisineapp.models.entities.UserIngredient;
import qc.colval.cuisineapp.models.entities.id_classes.UserIngredientId;
import qc.colval.cuisineapp.services.UserIngredientService;
import qc.colval.cuisineapp.services.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final EntityMapper<User, UserDTO> userMapper;
    private final UserIngredientService userIngredientService;
    private final EntityMapper<UserIngredient, UserIngredientDTO> userIngredientMapper;

    //GET MAPPINGS
    @GetMapping("/{id}")
    public User getUserWithId(@PathVariable Integer id){
        return userService.findById(id).orElse(null);
    }

    @GetMapping("/ingredient/{id}")
    public List<UserIngredient> findIngredientsByUser(@PathVariable Integer id){
        return userIngredientService.findUserIngredientByUser(id);
    }

    //POST MAPPINGS
    @PostMapping
    public User addUser(@RequestBody UserDTO userDTO){
        return userService.save(userMapper.dtoToEntity(userDTO));
    }

    @PostMapping("/ingredient")
    public UserIngredient addUserIngredient(@RequestBody UserIngredientDTO userIngredientDTO){
        return userIngredientService.save(userIngredientMapper.dtoToEntity(userIngredientDTO));
    }

    //PUT MAPPINGS
    @PutMapping("/password/{id}")
    public User updateUserPassword(@PathVariable Integer id, @RequestBody Map<String, String> newPassword){
        User user = userService.findById(id).orElse(null);
        if (user != null){
            user.setUserPassword(newPassword.get("newPassword"));
            userService.save(user);
        }
        return null;
    }

    @PutMapping("/ingredient")
    public UserIngredient userIngredient(@RequestBody UserIngredientDTO userIngredientDTO){
        UserIngredient userIngredient = userIngredientService.findById(
                new UserIngredientId(
                        userIngredientDTO.getUserId(),
                        userIngredientDTO.getIngredientId()))
                .orElse(null);
        if (userIngredient != null){
            userIngredient.setQuantity(userIngredientDTO.getQuantity());
            return userIngredientService.save(userIngredient);
        }
        return null;
    }

    //DELETE MAPPINGS
    @DeleteMapping("/ingredient/{userId}/{ingredientId}")
    public String deleteUserIngredient(@PathVariable Integer userId, @PathVariable Integer ingredientId){
        userIngredientService.deleteById(new UserIngredientId(userId, ingredientId));
        return "Ingredient Deleted Successfully";
    }

    @DeleteMapping("/ingredient/{userId}")
    public String deleteUser(@PathVariable Integer userId){
        userService.deleteById(userId);
        return "Ingredient User Successfully";
    }
}
