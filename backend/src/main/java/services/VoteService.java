package services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.IVoteRepository;

@Service
@AllArgsConstructor
public class VoteService {
    private final IVoteRepository repos;
}
