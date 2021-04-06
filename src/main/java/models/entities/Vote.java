package models.entities;

import lombok.*;
import models.entities.id_classes.VoteId;

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
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "RecipeId", referencedColumnName = "RecipeId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Recipe recipe;

    @Column(name = "VoteValue")
    private Integer voteValue;
}
