package qc.colval.cuisineapp.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "UserName")
    @Size(min = 2, max = 50)
    private String userName;

    @Column(name = "email")
    @Size(min = 2, max = 50)
    private String email;

    @Column(name = "UserPassword")
    @Size(min = 2, max = 50)
    private String userPassword;
}
