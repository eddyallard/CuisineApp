package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
