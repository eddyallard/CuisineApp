package services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repositories.IUserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final IUserRepository repos;
}
