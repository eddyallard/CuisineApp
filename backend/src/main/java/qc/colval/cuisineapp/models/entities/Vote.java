package qc.colval.cuisineapp.models.entities;

import lombok.*;
import qc.colval.cuisineapp.models.entities.id_classes.VoteId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Vote")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(VoteId.class)
public class Vote implements Serializable {
    @Id
    private Integer userId;

    @Id
    private Integer recipeId;

    @Column(name = "VoteValue")
    private Integer voteValue;
}
