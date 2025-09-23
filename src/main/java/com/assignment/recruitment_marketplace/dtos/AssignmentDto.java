package com.assignment.recruitment_marketplace.dtos;

import java.time.Instant;
import com.assignment.recruitment_marketplace.entities.enums.AssignmentStatus;

/**
 * DTO for JobAssignment entity.
 */
public class AssignmentDto {
    private Long id;
    private Long jobId;
    private Long candidateId;
    private AssignmentStatus status;
    private Instant createdAt;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }
    public Long getCandidateId() { return candidateId; }
    public void setCandidateId(Long candidateId) { this.candidateId = candidateId; }
    public AssignmentStatus getStatus() { return status; }
    public void setStatus(AssignmentStatus status) { this.status = status; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
