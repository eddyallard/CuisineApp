package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import qc.colval.cuisineapp.models.entities.User;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IUserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final IUserRepository repos;

    public void addUser(User user){
        user.setUserId(null);
        repos.save(user);
    }
}
