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
        List<Integer> votedRecipeIds = entity.getVotes()
                .stream()
                .map(vote -> vote.getRecipe().getRecipeId())
                .collect(Collectors.toList());

        List<Integer> authoredRecipeIds = entity.getRecipes()
                .stream()
                .map(Recipe::getRecipeId)
                .collect(Collectors.toList());

        List<Integer> ingredientIds = entity.getIngredients()
                .stream()
                .map(userIngredient -> userIngredient.getIngredient().getIngredientId())
                .collect(Collectors.toList());

        return new UserDTO(
                entity.getUserId(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getUserPassword(),
                authoredRecipeIds,
                votedRecipeIds,
                ingredientIds
        );
    }

    @Override
    public User dtoToEntity(UserDTO userDTO) {
        List<Vote> votes = userDTO.getVotedRecipeIds()
                .stream()
                .map(votedRecipeId -> voteService
                        .findById(new VoteId(
                                recipeService.findById(votedRecipeId).get(),
                                userService.findById(userDTO.getUserId()).get()))
                        .get())
                .collect(Collectors.toList());

        List<Recipe> recipes = userDTO.getAuthoredRecipeIds()
                .stream()
                .map(authoredRecipe -> recipeService.findById(authoredRecipe).get())
                .collect(Collectors.toList());

        List<UserIngredient> ingredients = userDTO.getIngredientIds()
                .stream()
                .map(ingredient -> userIngredientService.findById(
                        new UserIngredientId(
                                userService.findById(userDTO.getUserId()).get(),
                                ingredientService.findById(ingredient).get()))
                        .get())
                .collect(Collectors.toList());

        return new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                userDTO.getUserPassword(),
                votes,
                recipes,
                ingredients
        );
    }
}
