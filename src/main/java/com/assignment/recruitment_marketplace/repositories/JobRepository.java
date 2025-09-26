package com.assignment.recruitment_marketplace.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.recruitment_marketplace.entities.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
   
    Page<Job> findByRequiredSkillsContainingIgnoreCase(String skill, Pageable pageable);

    /**
     * Find jobs by organization id with paging.
     */
    Page<Job> findByOrganizationId(Long organizationId, Pageable pageable);
}
