package qc.colval.cuisineapp.rest_controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.VoteDTO;
import qc.colval.cuisineapp.models.entities.Vote;
import qc.colval.cuisineapp.models.entities.id_classes.VoteId;
import qc.colval.cuisineapp.services.VoteService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/vote")
@AllArgsConstructor
public class VoteController {
    private final VoteService voteService;
    private final EntityMapper<Vote, VoteDTO> voteMapper;

    @GetMapping("/{recipeId}")
    public List<Vote> getVotesByRecipe(@PathVariable Integer recipeId){
        return voteService.getVotesByRecipeId(recipeId);
    }

    @PostMapping
    public Vote postVote(@RequestBody VoteDTO voteDTO){
        Vote vote = voteMapper.dtoToEntity(voteDTO);
        Optional<Vote> existing = voteService.findById(new VoteId(vote.getRecipeId(), vote.getUserId()));
        //If the value of the vote changes
        if (existing.isPresent() && !existing.get().getVoteValue().equals(vote.getVoteValue())){
            Vote updatedVote = existing.get();
            updatedVote.setVoteValue(vote.getVoteValue());
            return voteService.save(updatedVote);
        }
        //Else if the vote didnt exist;
        else if (existing.isEmpty()){
            return voteService.save(vote);
        }
        return null;
    }
}
