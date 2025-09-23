package com.assignment.recruitment_marketplace.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.assignment.recruitment_marketplace.entities.*;
import com.assignment.recruitment_marketplace.repositories.*;

/**
 * Seeds roles and a default admin user at startup.
 */
@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initData(RoleRepository roleRepo,
                               UserRepository userRepo,
                               PasswordEncoder encoder) {
        return args -> {
            // Create roles if missing
            Role adminRole = roleRepo.findByName("ROLE_ADMIN")
                    .orElseGet(() -> roleRepo.save(new Role(null, "ROLE_ADMIN")));
            Role orgAdminRole = roleRepo.findByName("ROLE_ORGADMIN")
                    .orElseGet(() -> roleRepo.save(new Role(null, "ROLE_ORGADMIN")));
            Role userRole = roleRepo.findByName("ROLE_USER")
                    .orElseGet(() -> roleRepo.save(new Role(null, "ROLE_USER")));

            // Create admin user if missing
            if (userRepo.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123")); // default password
                admin.setRoles(Set.of(adminRole));
                admin.setEnabled(true);
                userRepo.save(admin);
            }
        };
    }
}
