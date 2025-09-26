package com.assignment.recruitment_marketplace.services;

import org.springframework.stereotype.Service;
import com.assignment.recruitment_marketplace.dtos.CandidateDto;
import com.assignment.recruitment_marketplace.entities.Candidate;
import com.assignment.recruitment_marketplace.entities.Organization;
import com.assignment.recruitment_marketplace.mapper.RecruitmentMapper;
import com.assignment.recruitment_marketplace.repositories.CandidateRepository;
import com.assignment.recruitment_marketplace.repositories.OrganizationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Candidate service with pageable search.
 */
@Service
public class CandidateService {
    private final CandidateRepository candRepo;
    private final OrganizationRepository orgRepo;
    private final RecruitmentMapper mapper;

    public CandidateService(CandidateRepository candRepo, OrganizationRepository orgRepo, RecruitmentMapper mapper) {
        this.candRepo = candRepo;
        this.orgRepo = orgRepo;
        this.mapper = mapper;
    }

    public CandidateDto create(CandidateDto dto) {
        Organization org = orgRepo.findById(dto.getOrganizationId())
                .orElseThrow(() -> new IllegalArgumentException("Organization not found: " + dto.getOrganizationId()));
        Candidate entity = mapper.toEntity(dto);
        entity.setOrganization(org);
        Candidate saved = candRepo.save(entity);
        return mapper.toDto(saved);
    }

    public Page<CandidateDto> search(String skills, String location, Pageable pageable) {
        return candRepo.searchBySkillsAndLocation(skills, location, pageable).map(mapper::toDto);
    }

    public Page<CandidateDto> findByOrganization(Long orgId, Pageable pageable) {
        return candRepo.findByOrganizationId(orgId, pageable).map(mapper::toDto);
    }
}
