package com.assignment.recruitment_marketplace.exception;

/**
 * Thrown when the client request is invalid or violates business rules (maps to HTTP 400).
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
