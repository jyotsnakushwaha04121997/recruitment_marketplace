package com.assignment.recruitment_marketplace.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.assignment.recruitment_marketplace.dtos.*;
import com.assignment.recruitment_marketplace.entities.*;

/**
 * MapStruct mapper: converts between Entities and DTOs.
 */
@Mapper(componentModel = "spring")
public interface RecruitmentMapper {

    // --- Organization ---
    OrganizationDto toDto(Organization entity);
    Organization toEntity(OrganizationDto dto);

    // --- Job ---
    @Mapping(source = "organization.id", target = "organizationId")
    JobDto toDto(Job entity);

    @Mapping(source = "organizationId", target = "organization.id")
    Job toEntity(JobDto dto);

    // --- Candidate ---
    @Mapping(source = "organization.id", target = "organizationId")
    CandidateDto toDto(Candidate entity);

    @Mapping(source = "organizationId", target = "organization.id")
    Candidate toEntity(CandidateDto dto);

    // --- Assignment ---
    @Mapping(source = "job.id", target = "jobId")
    @Mapping(source = "candidate.id", target = "candidateId")
    AssignmentDto toDto(JobAssignment entity);

    @Mapping(source = "jobId", target = "job.id")
    @Mapping(source = "candidateId", target = "candidate.id")
    JobAssignment toEntity(AssignmentDto dto);
}

