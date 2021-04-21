package qc.colval.cuisineapp.repositories;

import qc.colval.cuisineapp.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUserName(String userName);
}
