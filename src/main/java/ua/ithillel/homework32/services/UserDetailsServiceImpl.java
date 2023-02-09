package ua.ithillel.homework32.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.ithillel.homework32.entity.User;
import ua.ithillel.homework32.repository.UserRepository;
import ua.ithillel.homework32.security.UserDetailsImpl;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByName(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No user with such name");
        }
        return new UserDetailsImpl(user.get());
    }
}



