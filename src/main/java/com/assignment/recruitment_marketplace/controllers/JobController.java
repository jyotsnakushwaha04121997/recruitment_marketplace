package com.assignment.recruitment_marketplace.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.assignment.recruitment_marketplace.dtos.JobDto;
import com.assignment.recruitment_marketplace.services.JobService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Job REST endpoints with pagination & filtering.
 */
@RestController
@RequestMapping("/api/jobs")
@Tag(name = "Jobs", description = "APIs for job postings")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @Operation(summary = "Create a job")
    @PostMapping
    public ResponseEntity<JobDto> create(@Valid @RequestBody JobDto dto) {
        JobDto created = service.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(summary = "Search jobs by skill (paginated)")
    @GetMapping("/search")
    public Page<JobDto> searchBySkill(@RequestParam(required = false) String skill,
                                      @PageableDefault(size = 10) Pageable pageable) {
        return service.searchBySkill(skill, pageable);
    }

    @Operation(summary = "List jobs for organization (paginated)")
    @GetMapping("/org/{orgId}")
    public Page<JobDto> listByOrganization(@PathVariable Long orgId,
                                           @PageableDefault(size = 10) Pageable pageable) {
        return service.findByOrganization(orgId, pageable);
    }

    @Operation(summary = "List all jobs (paginated)")
    @GetMapping
    public Page<JobDto> listAll(@PageableDefault(size = 10) Pageable pageable) {
        return service.searchBySkill(null, pageable);
    }
}
