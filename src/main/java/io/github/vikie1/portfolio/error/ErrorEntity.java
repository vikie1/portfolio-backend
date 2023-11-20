package io.github.vikie1.portfolio.error;

import org.springframework.http.HttpStatus;

public record ErrorEntity(String status, int statusCode, String reason, String message) { }
