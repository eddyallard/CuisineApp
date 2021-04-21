package qc.colval.cuisineapp.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import qc.colval.cuisineapp.models.entities.User;
import qc.colval.cuisineapp.repositories.IUserRepository;

@AllArgsConstructor
@Service
public class UserPrincipalDetailService implements UserDetailsService {
    private final IUserRepository repos;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = repos.findUserByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found."));
        return new UserPrincipal(user);
    }
}
