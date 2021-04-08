package qc.colval.cuisineapp.models.entities;

import lombok.*;
import qc.colval.cuisineapp.models.entities.id_classes.VoteId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Vote")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(VoteId.class)
public class Vote implements Serializable {
    @Id
    @NotNull
    private Integer userId;

    @Id
    @NotNull
    private Integer recipeId;

    @Column(name = "VoteValue")
    @NotNull
    private Integer voteValue;
}
