package services;

import lombok.AllArgsConstructor;
import models.entities.User;
import models.entities.Vote;
import org.springframework.stereotype.Service;
import repositories.IVoteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VoteService {
    private final IVoteRepository repos;

    List<Vote> findByUser(Integer id){
        return repos.findByUserId(id);
    }
}
