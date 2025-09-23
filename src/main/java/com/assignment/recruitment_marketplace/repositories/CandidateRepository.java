package com.assignment.recruitment_marketplace.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.recruitment_marketplace.entities.Candidate;

/**
 * Repository for Candidate entity.
 */
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("SELECT c FROM Candidate c " +
           "WHERE (:skills IS NULL OR LOWER(c.primarySkills) LIKE LOWER(CONCAT('%', :skills, '%'))) " +
           "AND (:location IS NULL OR LOWER(c.currentLocation) = LOWER(:location))")
    List<Candidate> searchCandidates(String skills, String location);
}
