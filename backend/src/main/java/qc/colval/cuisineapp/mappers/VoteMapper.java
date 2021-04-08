package qc.colval.cuisineapp.mappers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.dto.VoteDTO;
import qc.colval.cuisineapp.models.entities.Vote;

@Service
@AllArgsConstructor
public class VoteMapper implements EntityMapper<Vote, VoteDTO>{
    @Override
    public VoteDTO entityToDto(Vote entity) {
        return new VoteDTO(
                entity.getUserId(),
                entity.getRecipeId(),
                entity.getVoteValue()
        );
    }

    @Override
    public Vote dtoToEntity(VoteDTO voteDTO) {
        return new Vote(
                voteDTO.getUserId(),
                voteDTO.getRecipeId(),
                voteDTO.getVoteValue()
        );
    }
}
