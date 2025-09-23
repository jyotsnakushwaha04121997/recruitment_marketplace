package com.assignment.recruitment_marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.recruitment_marketplace.entities.VendorClientRelation;

/**
 * Repository for vendor-client relationships.
 */
public interface VendorClientRelationRepository extends JpaRepository<VendorClientRelation, Long> {
}
