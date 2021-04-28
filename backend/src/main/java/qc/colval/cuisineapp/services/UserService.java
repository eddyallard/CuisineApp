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

    public Optional<User> findByUsername(String username) {
        return repos.findUserByUserName(username);
    }
    public User save(User user){
        return repos.save(user);
    }

    public User saveNew(User user) throws Exception {
        user.setUserId(null);
        user.encryptPassword(encoder);
        user.setPermissions("");
        user.setRoles("");
        user.setActive(true);
        if(repos.findUserByUserName(user.getUserName()).isPresent()){
            throw new Exception("Username already taken.");
        }
        return repos.save(user);
    }

    public void deleteById(Integer id){
        repos.deleteById(id);
    }
}
