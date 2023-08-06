package com.example.cinema.models.utils.errors;

public class InvalidPasswordError extends RuntimeException {
    public InvalidPasswordError(String message) {
        super(message);
    }
}
