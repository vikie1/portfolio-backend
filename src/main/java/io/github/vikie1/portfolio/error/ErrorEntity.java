package io.github.vikie1.portfolio.error;
public record ErrorEntity(String status, int statusCode, String reason, String message) { }