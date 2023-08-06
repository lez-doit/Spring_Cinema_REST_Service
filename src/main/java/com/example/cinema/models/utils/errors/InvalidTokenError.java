package com.example.cinema.models.utils.errors;

public class InvalidTokenError extends RuntimeException{
    public InvalidTokenError(String message) {
        super(message);
    }
}
