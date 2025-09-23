package com.assignment.recruitment_marketplace.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.recruitment_marketplace.entities.User;

/**
 * Repository for User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

