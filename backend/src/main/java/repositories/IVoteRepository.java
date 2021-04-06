package repositories;

import models.entities.id_classes.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVoteRepository extends JpaRepository<IVoteRepository, VoteId> {
}
