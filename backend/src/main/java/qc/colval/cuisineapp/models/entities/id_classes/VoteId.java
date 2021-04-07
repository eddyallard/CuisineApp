package qc.colval.cuisineapp.models.entities.id_classes;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoteId implements Serializable {
    private Integer recipeId;
    private Integer userId;
}
