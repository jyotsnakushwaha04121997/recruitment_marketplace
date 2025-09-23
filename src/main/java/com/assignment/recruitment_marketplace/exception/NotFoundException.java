package com.assignment.recruitment_marketplace.exception;

/**
 * Thrown when a requested resource is not found (maps to HTTP 404).
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
