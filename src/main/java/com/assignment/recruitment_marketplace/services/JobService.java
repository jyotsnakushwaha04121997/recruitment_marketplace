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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Job service with pageable search.
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
                .orElseThrow(() -> new IllegalArgumentException("Organization not found: " + dto.getOrganizationId()));
        Job job = mapper.toEntity(dto);
        job.setOrganization(org);
        Job saved = jobRepo.save(job);
        return mapper.toDto(saved);
    }

    public Page<JobDto> searchBySkill(String skill, Pageable pageable) {
        // If skill is null or empty, return all jobs as page
        if (skill == null || skill.isBlank()) {
            return jobRepo.findAll(pageable).map(mapper::toDto);
        }
        return jobRepo.findByRequiredSkillsContainingIgnoreCase(skill, pageable).map(mapper::toDto);
    }

    public Page<JobDto> findByOrganization(Long orgId, Pageable pageable) {
    	return jobRepo.findByOrganizationId(orgId, pageable).map(mapper::toDto);
    }
}

