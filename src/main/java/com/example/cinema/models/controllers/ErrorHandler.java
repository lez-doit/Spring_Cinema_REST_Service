package com.example.cinema.models.controllers;

import com.example.cinema.models.dto.ErrorResponse;
import com.example.cinema.models.utils.errors.InvalidPasswordError;
import com.example.cinema.models.utils.errors.InvalidSeatError;
import com.example.cinema.models.utils.errors.InvalidTokenError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ErrorHandler {

  @ExceptionHandler(InvalidSeatError.class)
  private ResponseEntity<ErrorResponse> exceptionHandler(InvalidSeatError error) {
    ErrorResponse response = new ErrorResponse(error.getMessage());

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InvalidTokenError.class)
  private ResponseEntity<ErrorResponse> exceptionHandler(InvalidTokenError error) {
    ErrorResponse response = new ErrorResponse(error.getMessage());

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InvalidPasswordError.class)
  private ResponseEntity<ErrorResponse> exceptionHandler(InvalidPasswordError error) {
    ErrorResponse response = new ErrorResponse(error.getMessage());

    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
  }
}
