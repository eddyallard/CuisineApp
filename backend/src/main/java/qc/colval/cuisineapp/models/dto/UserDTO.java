package qc.colval.cuisineapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Integer userId;
    private String userName;
    private String email;
    private String userPassword;
    private List<Integer> authoredRecipeIds;
    private List<Integer> votedRecipeIds;
    private List<Integer> ingredientIds;
}
