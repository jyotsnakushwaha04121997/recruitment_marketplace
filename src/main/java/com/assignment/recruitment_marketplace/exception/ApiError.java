package com.assignment.recruitment_marketplace.exception;

import java.time.Instant;
import java.util.List;

/**
 * Standard API error payload returned to clients.
 * - status: HTTP status code
 * - error: short phrase
 * - message: human-friendly message
 * - timestamp: instant when error occurred
 * - fieldErrors: optional list of field-specific validation errors
 */
public record ApiError(int status, String error, String message, Instant timestamp, List<FieldError> fieldErrors) {
    public record FieldError(String field, String message) {}
}
