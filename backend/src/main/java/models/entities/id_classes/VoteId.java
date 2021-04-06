package models.entities.id_classes;

import models.entities.Recipe;
import models.entities.User;

import java.io.Serializable;

public class VoteId implements Serializable {
    private Recipe recipe;
    private User user;
}
