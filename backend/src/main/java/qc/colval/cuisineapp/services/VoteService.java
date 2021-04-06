package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.entities.Vote;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IVoteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VoteService {
    private final IVoteRepository repos;

    public List<Vote> findByUserId(Integer id){
        return repos.findByUserId(id);
    }
}
