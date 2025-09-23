package com.assignment.recruitment_marketplace.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.assignment.recruitment_marketplace.dtos.JobDto;
import com.assignment.recruitment_marketplace.services.JobService;

import jakarta.validation.Valid;

/**
 * REST controller for Job postings.
 */
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping
    public JobDto create(@Valid @RequestBody JobDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<JobDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<JobDto> search(@RequestParam String skill) {
        return service.searchBySkill(skill);
    }
}
