package com.assignment.recruitment_marketplace.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.assignment.recruitment_marketplace.dtos.AssignmentDto;
import com.assignment.recruitment_marketplace.services.JobAssignmentService;

import jakarta.validation.Valid;

/**
 * REST controller for Job Assignments.
 */
@RestController
@RequestMapping("/api/assignments")
public class JobAssignmentController {

    private final JobAssignmentService service;

    public JobAssignmentController(JobAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentDto create(@Valid @RequestBody AssignmentDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<AssignmentDto> findAll() {
        return service.findAll();
    }
}
