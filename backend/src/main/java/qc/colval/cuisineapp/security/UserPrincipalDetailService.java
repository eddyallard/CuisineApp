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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repos.findUserByUserName(s)
                .orElseThrow(() -> new UsernameNotFoundException("User " + s + " not found."));
        return new UserPrincipal(user);
    }
}
