package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.Vote;
import qc.colval.cuisineapp.models.entities.id_classes.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface IVoteRepository extends JpaRepository<Vote, VoteId> {
    List<Vote> getVotesByRecipeId(Integer recipeId);
    Integer getVoteCountByRecipeId(Integer recipeId);
}
