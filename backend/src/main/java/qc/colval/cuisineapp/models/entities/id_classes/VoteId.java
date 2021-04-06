package qc.colval.cuisineapp.models.entities.id_classes;

import lombok.*;
import qc.colval.cuisineapp.models.entities.Recipe;
import qc.colval.cuisineapp.models.entities.User;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoteId implements Serializable {
    private Recipe recipe;
    private User user;
}
