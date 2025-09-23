package com.assignment.recruitment_marketplace.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.recruitment_marketplace.entities.JobAssignment;

/**
 * Repository for JobAssignment entity.
 */
public interface JobAssignmentRepository extends JpaRepository<JobAssignment, Long> {
}

