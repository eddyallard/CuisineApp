package models.entities.id_classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.entities.Recipe;
import models.entities.User;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VoteId implements Serializable {
    private Recipe recipe;
    private User user;
}
