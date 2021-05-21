package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.VoteDTO;
import qc.colval.cuisineapp.models.entities.Vote;
import qc.colval.cuisineapp.models.entities.id_classes.VoteId;
import qc.colval.cuisineapp.services.VoteService;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/vote")
@AllArgsConstructor
public class VoteController {
    private final VoteService voteService;
    private final EntityMapper<Vote, VoteDTO> voteMapper;

    @GetMapping("/{recipeId}")
    public ResponseEntity<List<VoteDTO>> getVotesByRecipe(@PathVariable Integer recipeId){
        return ResponseEntity.ok(voteService.getVotesByRecipeId(recipeId)
                .stream().map(voteMapper::entityToDto)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<VoteDTO> postVote(@RequestBody VoteDTO voteDTO){
        Vote vote = voteMapper.dtoToEntity(voteDTO);
        Optional<Vote> existing = voteService.findById(new VoteId(vote.getRecipeId(), vote.getUserId()));
        if (voteDTO.getVoteValue() == 1 || voteDTO.getVoteValue() == -1) {
            //If the value of the vote changes
            existing.ifPresent(value -> {
            });
            if (existing.isPresent() && !existing.get().getVoteValue().equals(vote.getVoteValue())) {
                Vote updatedVote = existing.get();
                updatedVote.setVoteValue(vote.getVoteValue());
                return ResponseEntity.ok(voteMapper.entityToDto(voteService.save(updatedVote)));
            }
            //Else if the vote didnt exist;
            else if (!existing.isPresent()) {
                Vote saved = voteService.save(vote);
                return ResponseEntity.created(URI.create(vote.getRecipeId().toString() + "_" + vote.getUserId().toString()))
                        .body(voteMapper.entityToDto(saved));
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
