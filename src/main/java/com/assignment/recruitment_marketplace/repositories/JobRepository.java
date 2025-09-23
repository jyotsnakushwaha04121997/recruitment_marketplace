package com.assignment.recruitment_marketplace.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.recruitment_marketplace.entities.Job;

/**
 * Repository for Job entity.
 */
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j WHERE LOWER(j.requiredSkills) LIKE LOWER(CONCAT('%', :skill, '%'))")
    List<Job> findBySkillContainingIgnoreCase(String skill);
}
