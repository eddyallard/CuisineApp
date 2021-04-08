package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.entities.User;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IUserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final IUserRepository repos;

    public Optional<User> findById(Integer id){
        return repos.findById(id);
    }
    public User save(User user){
        user.setUserId(null);
        return repos.save(user);
    }

    public void deleteById(Integer id){
        repos.deleteById(id);
    }
}
