package com.example.cinema.models.utils.errors;

public class InvalidSeatError extends RuntimeException {
  public InvalidSeatError(String message) {
    super(message);
  }
}
