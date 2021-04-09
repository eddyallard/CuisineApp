package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.IngredientDTO;
import qc.colval.cuisineapp.models.dto.UserDTO;
import qc.colval.cuisineapp.models.dto.UserIngredientDTO;
import qc.colval.cuisineapp.models.dto.combined.IngredientQuantityDTO;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.models.entities.User;
import qc.colval.cuisineapp.models.entities.UserIngredient;
import qc.colval.cuisineapp.models.entities.id_classes.UserIngredientId;
import qc.colval.cuisineapp.services.IngredientService;
import qc.colval.cuisineapp.services.UserIngredientService;
import qc.colval.cuisineapp.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final IngredientService ingredientService;
    private final EntityMapper<User, UserDTO> userMapper;
    private final UserIngredientService userIngredientService;
    private final EntityMapper<UserIngredient, UserIngredientDTO> userIngredientMapper;
    private final EntityMapper<Ingredient, IngredientDTO> ingredientMapper;

    //GET MAPPINGS
    @GetMapping("/{id}")
    public UserDTO getUserWithId(@PathVariable Integer id){
        return userMapper.entityToDto(userService.findById(id).orElse(null));
    }

    @GetMapping("/ingredient/{id}")
    public List<IngredientQuantityDTO> findIngredientsByUser(@PathVariable Integer id){
        List<IngredientQuantityDTO> ingredientQuantities = new ArrayList<>();
        userIngredientService.findUserIngredientByUser(id).forEach( recipeIngredient -> {
            ingredientQuantities.add(new IngredientQuantityDTO(
                    ingredientMapper.entityToDto(ingredientService.findById(recipeIngredient.getIngredientId()).orElse(null)),
                    recipeIngredient.getQuantity()));
        });
        return ingredientQuantities;
    }

    //POST MAPPINGS
    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return userMapper.entityToDto(userService.save(userMapper.dtoToEntity(userDTO)));
    }

    @PostMapping("/ingredient")
    public UserIngredientDTO addUserIngredient(@RequestBody UserIngredientDTO userIngredientDTO){
        return userIngredientMapper.entityToDto(userIngredientService.save(userIngredientMapper.dtoToEntity(userIngredientDTO)));
    }

    //PUT MAPPINGS
    @PutMapping("/password/{id}")
    public UserDTO updateUserPassword(@PathVariable Integer id, @RequestBody Map<String, String> newPassword){
        User user = userService.findById(id).orElse(null);
        if (user != null){
            user.setUserPassword(newPassword.get("newPassword"));
            userMapper.entityToDto(userService.save(user));
        }
        return null;
    }

    @PutMapping("/ingredient")
    public UserIngredientDTO userIngredient(@RequestBody UserIngredientDTO userIngredientDTO){
        UserIngredient userIngredient = userIngredientService.findById(
                new UserIngredientId(
                        userIngredientDTO.getUserId(),
                        userIngredientDTO.getIngredientId()))
                .orElse(null);
        if (userIngredient != null){
            userIngredient.setQuantity(userIngredientDTO.getQuantity());
            return userIngredientMapper.entityToDto(userIngredientService.save(userIngredient));
        }
        return null;
    }

    //DELETE MAPPINGS
    @DeleteMapping("/ingredient/{userId}/{ingredientId}")
    public String deleteUserIngredient(@PathVariable Integer userId, @PathVariable Integer ingredientId){
        userIngredientService.deleteById(new UserIngredientId(userId, ingredientId));
        return "User Ingredient Deleted Successfully";
    }

    @DeleteMapping("/ingredient/{userId}")
    public String deleteUser(@PathVariable Integer userId){
        userService.deleteById(userId);
        return "User Successfully";
    }
}
