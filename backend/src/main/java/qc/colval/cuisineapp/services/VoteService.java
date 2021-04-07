package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.entities.Vote;
import org.springframework.stereotype.Service;
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

}
