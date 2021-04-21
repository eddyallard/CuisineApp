package qc.colval.cuisineapp.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import qc.colval.cuisineapp.models.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //extract list of permissions (name)
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.user.getPermissionsList().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });

        //extract list of roles (Role_name)
        this.user.getRolesList().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + p);
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isActive();
    }
}

