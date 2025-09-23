package com.assignment.recruitment_marketplace.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.recruitment_marketplace.dtos.OrganizationDto;
import com.assignment.recruitment_marketplace.entities.Organization;
import com.assignment.recruitment_marketplace.mapper.RecruitmentMapper;
import com.assignment.recruitment_marketplace.repositories.OrganizationRepository;

/**
 * Service for Organization management.
 */
@Service
public class OrganizationService {
    private final OrganizationRepository orgRepo;
    private final RecruitmentMapper mapper;

    public OrganizationService(OrganizationRepository orgRepo, RecruitmentMapper mapper) {
        this.orgRepo = orgRepo;
        this.mapper = mapper;
    }

    public OrganizationDto create(OrganizationDto dto) {
        Organization saved = orgRepo.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    public List<OrganizationDto> findAll() {
        return orgRepo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public OrganizationDto findById(Long id) {
        return orgRepo.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Organization not found"));
    }
}
