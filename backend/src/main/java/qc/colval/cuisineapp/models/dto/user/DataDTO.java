package qc.colval.cuisineapp.models.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataDTO {
    private Integer userId;
    private String userName;
    private String email;
    private String userPassword;
}
