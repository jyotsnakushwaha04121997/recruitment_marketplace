package com.assignment.recruitment_marketplace.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.recruitment_marketplace.dtos.CandidateDto;
import com.assignment.recruitment_marketplace.entities.Candidate;
import com.assignment.recruitment_marketplace.entities.Organization;
import com.assignment.recruitment_marketplace.mapper.RecruitmentMapper;
import com.assignment.recruitment_marketplace.repositories.CandidateRepository;
import com.assignment.recruitment_marketplace.repositories.OrganizationRepository;

/**
 * Service for Candidate management.
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
                .orElseThrow(() -> new RuntimeException("Organization not found"));
        Candidate entity = mapper.toEntity(dto);
        entity.setOrganization(org);
        Candidate saved = candRepo.save(entity);
        return mapper.toDto(saved);
    }

    public List<CandidateDto> search(String skills, String location) {
        return candRepo.searchCandidates(skills, location)
                       .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<CandidateDto> findAll() {
        return candRepo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
