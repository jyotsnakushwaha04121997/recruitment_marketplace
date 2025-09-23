package com.assignment.recruitment_marketplace.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Service for handling file uploads (resumes, logos).
 */
@Service
public class FileStorageService {

    private final Path uploadDir;

    public FileStorageService(@Value("${app.upload.dir}") String uploadDir) throws IOException {
        this.uploadDir = Paths.get(uploadDir);
        if (!Files.exists(this.uploadDir)) {
            Files.createDirectories(this.uploadDir);
        }
    }

    public String storeFile(MultipartFile file) throws IOException {
        Path target = uploadDir.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), target);
        return target.toString();
    }
}
