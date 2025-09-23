package com.assignment.recruitment_marketplace.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.assignment.recruitment_marketplace.entities.User;
import com.assignment.recruitment_marketplace.repositories.UserRepository;

/**
 * Loads UserDetails from DB for Spring Security.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // already encoded
                .disabled(!user.isEnabled())
                .authorities(user.getRoles().stream().map(r -> r.getName()).toArray(String[]::new))
                .build();
    }
}
