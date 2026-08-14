package com.contactapp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Validation Exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        return new ResponseEntity<>(
                errors,
                HttpStatus.BAD_REQUEST
        );
    }

    // 2. Contact Not Found
    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<String> handleContactNotFound(
            ContactNotFoundException exception) {

        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    // 3. Duplicate Email / Phone
    @ExceptionHandler(DuplicateContactException.class)
    public ResponseEntity<String> handleDuplicateContact(
            DuplicateContactException exception) {

        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.CONFLICT
        );
    }

    // 4. Database Unique Constraint Exception
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(
            DataIntegrityViolationException exception) {

        return new ResponseEntity<>(
                "Email or phone number already exists",
                HttpStatus.CONFLICT
        );
    }

    // 5. Any Unexpected Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(
            Exception exception) {

        return new ResponseEntity<>(
                "Something went wrong. Please try again later.",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}