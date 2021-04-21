package qc.colval.cuisineapp.models.entities;


import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedQueries({
        @NamedQuery(name = "User.findUserByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName")
})
public class User implements Serializable {
    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer userId;

    @Column(name = "UserName")
    @Size(min = 2, max = 50)
    @NotNull
    private String userName;

    @Column(name = "email")
    @Size(min = 2, max = 50)
    @NotNull
    private String email;

    @Column(name = "UserPassword")
    @Size(min = 2, max = 50)
    @NotNull
    private String userPassword;

    @Column(name = "Roles")
    private String roles;

    @Column(name = "Permissions")
    private String permissions;

    @Column(name = "Active")
    private boolean active = true;

    public List<String> getRolesList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionsList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    public void encryptPassword(PasswordEncoder encoder){
        this.setUserPassword(encoder.encode(this.getUserPassword()));
    }
}
