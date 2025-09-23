package com.assignment.recruitment_marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.recruitment_marketplace.entities.Organization;

/**
 * Repository for Organization entity.
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
