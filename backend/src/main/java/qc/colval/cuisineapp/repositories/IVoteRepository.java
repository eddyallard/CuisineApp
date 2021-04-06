package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.Vote;
import qc.colval.cuisineapp.models.entities.id_classes.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVoteRepository extends JpaRepository<Vote, VoteId> {
    List<Vote> findByUserId(Integer id);
}
