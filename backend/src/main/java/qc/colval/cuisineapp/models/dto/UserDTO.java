package qc.colval.cuisineapp.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qc.colval.cuisineapp.models.dto.user.DataDTO;
import qc.colval.cuisineapp.models.dto.user.SupportDTO;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    /*@JsonProperty("data")
    private DataDTO dataDTO;

    @JsonProperty("support")
    private SupportDTO supportDTO;*/
    private Integer userId;
    private String userName;
    private String email;
    private String userPassword;
    private String roles;
    private String permissions;
}
