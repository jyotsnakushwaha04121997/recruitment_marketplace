package com.assignment.recruitment_marketplace.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.assignment.recruitment_marketplace.dtos.OrganizationDto;
import com.assignment.recruitment_marketplace.services.OrganizationService;

import jakarta.validation.Valid;

/**
 * REST controller for Organizations.
 */
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping
    public OrganizationDto create(@Valid @RequestBody OrganizationDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<OrganizationDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrganizationDto findById(@PathVariable Long id) {
        return service.findById(id);
    }
}

