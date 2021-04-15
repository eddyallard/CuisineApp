package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
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

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<UserDTO> getUserWithId(@PathVariable Integer id){
        Optional<User> user = userService.findById(id);
        return user.map(value -> ResponseEntity.ok(userMapper.entityToDto(value)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<List<IngredientQuantityDTO>> findIngredientsByUser(@PathVariable Integer id){
        List<IngredientQuantityDTO> ingredientQuantities = new ArrayList<>();
        userIngredientService.findUserIngredientByUser(id).forEach( recipeIngredient -> {
            ingredientQuantities.add(new IngredientQuantityDTO(
                    ingredientMapper.entityToDto(ingredientService.findById(recipeIngredient.getIngredientId()).orElse(null)),
                    recipeIngredient.getQuantity()));
        });
        return ResponseEntity.ok(ingredientQuantities);
    }

    //POST MAPPINGS
    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        User saved = userService.save(userMapper.dtoToEntity(userDTO));
        return ResponseEntity.created(URI.create(saved.getUserId().toString())).body(userMapper.entityToDto(saved));
    }

    @PostMapping("/ingredient")
    public ResponseEntity<UserIngredientDTO> addUserIngredient(@RequestBody UserIngredientDTO userIngredientDTO){
        UserIngredient saved = userIngredientService.save(userIngredientMapper.dtoToEntity(userIngredientDTO));
        return ResponseEntity.created(URI.create(saved.getIngredientId().toString() + '_' + saved.getUserId().toString())).body(userIngredientMapper.entityToDto(saved));
    }

    //PUT MAPPINGS
    @PutMapping("/password/{id}")
    public ResponseEntity<UserDTO> updateUserPassword(@PathVariable Integer id, @RequestBody Map<String, String> newPassword){
        Optional<User> user = userService.findById(id);
        user.ifPresent(value -> value.setUserPassword(newPassword.get("newPassword")));
        return user.map(value -> ResponseEntity.ok(userMapper.entityToDto(userService.save(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/ingredient")
    public ResponseEntity<UserIngredientDTO> userIngredient(@RequestBody UserIngredientDTO userIngredientDTO){
        Optional<UserIngredient> userIngredient = userIngredientService.findById(
                new UserIngredientId(userIngredientDTO.getUserId(), userIngredientDTO.getIngredientId()));
        userIngredient.ifPresent(value -> value.setQuantity(userIngredientDTO.getQuantity()));
        return userIngredient.map(value -> ResponseEntity.ok(userIngredientMapper.entityToDto(userIngredientService.save(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //DELETE MAPPINGS
    @DeleteMapping("/ingredient")
    public ResponseEntity<String> deleteUserIngredient(@RequestParam Integer userId, @RequestParam Integer ingredientId){
        userIngredientService.deleteById(new UserIngredientId(userId, ingredientId));
        return ResponseEntity.ok("User Ingredient Deleted Successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        userService.deleteById(userId);
        return ResponseEntity.ok("User Successfully");
    }
}
