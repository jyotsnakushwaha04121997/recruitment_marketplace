package com.assignment.recruitment_marketplace.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.assignment.recruitment_marketplace.dtos.CandidateDto;
import com.assignment.recruitment_marketplace.services.CandidateService;

import jakarta.validation.Valid;

/**
 * REST controller for Candidates.
 */
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService service;

    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @PostMapping
    public CandidateDto create(@Valid @RequestBody CandidateDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<CandidateDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<CandidateDto> search(@RequestParam(required = false) String skills,
                                     @RequestParam(required = false) String location) {
        return service.search(skills, location);
    }
}
