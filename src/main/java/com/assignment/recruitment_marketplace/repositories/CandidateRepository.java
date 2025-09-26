package com.assignment.recruitment_marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.assignment.recruitment_marketplace.entities.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 * Candidate repository with pageable search by skills and location.
 */
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("SELECT c FROM Candidate c " +
           "WHERE (:skills IS NULL OR lower(c.primarySkills) LIKE lower(concat('%', :skills, '%'))) " +
           "AND (:location IS NULL OR lower(c.currentLocation) LIKE lower(concat('%', :location, '%')))")
    Page<Candidate> searchBySkillsAndLocation(@Param("skills") String skills,
                                              @Param("location") String location,
                                              Pageable pageable);

    Page<Candidate> findByOrganizationId(Long organizationId, Pageable pageable);
}

