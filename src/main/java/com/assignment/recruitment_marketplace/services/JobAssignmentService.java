package com.assignment.recruitment_marketplace.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.recruitment_marketplace.dtos.AssignmentDto;
import com.assignment.recruitment_marketplace.entities.Candidate;
import com.assignment.recruitment_marketplace.entities.Job;
import com.assignment.recruitment_marketplace.entities.JobAssignment;
import com.assignment.recruitment_marketplace.mapper.RecruitmentMapper;
import com.assignment.recruitment_marketplace.repositories.CandidateRepository;
import com.assignment.recruitment_marketplace.repositories.JobAssignmentRepository;
import com.assignment.recruitment_marketplace.repositories.JobRepository;

/**
 * Service for JobAssignment management.
 */
@Service
public class JobAssignmentService {
    private final JobAssignmentRepository assignRepo;
    private final JobRepository jobRepo;
    private final CandidateRepository candRepo;
    private final RecruitmentMapper mapper;

    public JobAssignmentService(JobAssignmentRepository assignRepo,
                                JobRepository jobRepo,
                                CandidateRepository candRepo,
                                RecruitmentMapper mapper) {
        this.assignRepo = assignRepo;
        this.jobRepo = jobRepo;
        this.candRepo = candRepo;
        this.mapper = mapper;
    }

    public AssignmentDto create(AssignmentDto dto) {
        Job job = jobRepo.findById(dto.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        Candidate cand = candRepo.findById(dto.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        JobAssignment entity = mapper.toEntity(dto);
        entity.setJob(job);
        entity.setCandidate(cand);

        JobAssignment saved = assignRepo.save(entity);
        return mapper.toDto(saved);
    }

    public List<AssignmentDto> findAll() {
        return assignRepo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}

