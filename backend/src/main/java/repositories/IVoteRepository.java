package repositories;

import models.entities.User;
import models.entities.Vote;
import models.entities.id_classes.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVoteRepository extends JpaRepository<Vote, VoteId> {
    List<Vote> findByUserId(Integer Id);
}
