package com.assignment.recruitment_marketplace.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.recruitment_marketplace.services.FileStorageService;

/**
 * REST controller for file uploads (resumes, logos, etc.).
 */
@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileStorageService storageService;

    public FileController(FileStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String path = storageService.storeFile(file);
        return ResponseEntity.ok("File stored at: " + path);
    }
}
