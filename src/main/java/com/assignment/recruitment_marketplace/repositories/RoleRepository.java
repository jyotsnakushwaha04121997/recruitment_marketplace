package com.assignment.recruitment_marketplace.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.recruitment_marketplace.entities.Role;

/**
 * Repository for Role entity.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
