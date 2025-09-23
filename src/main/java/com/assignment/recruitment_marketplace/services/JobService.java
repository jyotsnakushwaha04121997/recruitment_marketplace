package com.assignment.recruitment_marketplace.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.recruitment_marketplace.dtos.JobDto;
import com.assignment.recruitment_marketplace.entities.Job;
import com.assignment.recruitment_marketplace.entities.Organization;
import com.assignment.recruitment_marketplace.mapper.RecruitmentMapper;
import com.assignment.recruitment_marketplace.repositories.JobRepository;
import com.assignment.recruitment_marketplace.repositories.OrganizationRepository;

/**
 * Service for Job management.
 */
@Service
public class JobService {
    private final JobRepository jobRepo;
    private final OrganizationRepository orgRepo;
    private final RecruitmentMapper mapper;

    public JobService(JobRepository jobRepo, OrganizationRepository orgRepo, RecruitmentMapper mapper) {
        this.jobRepo = jobRepo;
        this.orgRepo = orgRepo;
        this.mapper = mapper;
    }

    public JobDto create(JobDto dto) {
        Organization org = orgRepo.findById(dto.getOrganizationId())
                .orElseThrow(() -> new RuntimeException("Organization not found"));
        Job entity = mapper.toEntity(dto);
        entity.setOrganization(org);
        Job saved = jobRepo.save(entity);
        return mapper.toDto(saved);
    }

    public List<JobDto> findAll() {
        return jobRepo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<JobDto> searchBySkill(String skill) {
        return jobRepo.findBySkillContainingIgnoreCase(skill)
                      .stream().map(mapper::toDto).collect(Collectors.toList());
    }
}

