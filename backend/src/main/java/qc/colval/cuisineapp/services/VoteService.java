package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.entities.Vote;
import qc.colval.cuisineapp.models.entities.id_classes.VoteId;
import qc.colval.cuisineapp.repositories.IVoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoteService {
    private final IVoteRepository repos;

    public Optional<Vote> findById(VoteId id){
        return repos.findById(id);
    }

    public Vote save(Vote vote){
        return repos.save(vote);
    }

    public List<Vote> getVotesByRecipeId(Integer recipeId){
        return repos.getVotesByRecipeId(recipeId);
    }
    public Integer getVoteCountByRecipeId(Integer recipeId){
        return repos.getVoteCountByRecipeId(recipeId);
    }

}
