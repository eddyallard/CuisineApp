package qc.colval.cuisineapp.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import qc.colval.cuisineapp.models.entities.User;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.repositories.IUserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final PasswordEncoder encoder;
    private final IUserRepository repos;

    public Optional<User> findById(Integer id){
        return repos.findById(id);
    }
    public User save(User user){
        user.setUserId(null);
        user.encryptPassword(encoder);
        user.setPermissions("");
        user.setRoles("");
        return repos.save(user);
    }

    public void deleteById(Integer id){
        repos.deleteById(id);
    }
}
