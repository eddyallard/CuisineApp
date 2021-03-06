package qc.colval.cuisineapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Integer userId;
    private String userName;
    private String email;
    private String userPassword;
    private String roles;
    private String permissions;
    private boolean active;
}
