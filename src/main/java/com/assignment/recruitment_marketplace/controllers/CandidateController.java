package com.assignment.recruitment_marketplace.controllers;

import org.springframework.web.bind.annotation.*;
import com.assignment.recruitment_marketplace.dtos.CandidateDto;
import com.assignment.recruitment_marketplace.services.CandidateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

/**
 * Candidate REST endpoints with pagination & filtering.
 */
@RestController
@RequestMapping("/api/candidates")
@Tag(name = "Candidates", description = "APIs for candidate management")
public class CandidateController {

    private final CandidateService service;

    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @Operation(summary = "Create a candidate")
    @PostMapping
    public ResponseEntity<CandidateDto> create(@Valid @RequestBody CandidateDto dto) {
        CandidateDto created = service.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(summary = "Search candidates by skills and location (paginated)")
    @GetMapping("/search")
    public Page<CandidateDto> search(@RequestParam(required = false) String skills,
                                     @RequestParam(required = false) String location,
                                     @PageableDefault(size = 10) Pageable pageable) {
        return service.search(skills, location, pageable);
    }

    @Operation(summary = "List candidates for organization (paginated)")
    @GetMapping("/org/{orgId}")
    public Page<CandidateDto> listByOrganization(@PathVariable Long orgId,
                                                 @PageableDefault(size = 10) Pageable pageable) {
        return service.findByOrganization(orgId, pageable);
    }

    @Operation(summary = "List all candidates (paginated)")
    @GetMapping
    public Page<CandidateDto> listAll(@PageableDefault(size = 10) Pageable pageable) {
        return service.findByOrganization(null, pageable); // fallback handled in repo if needed
    }
}
