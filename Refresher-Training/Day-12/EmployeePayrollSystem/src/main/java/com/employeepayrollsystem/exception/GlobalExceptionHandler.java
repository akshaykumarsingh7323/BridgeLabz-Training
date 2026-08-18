package com.employeepayrollsystem.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleEmployeeNotFound(EmployeeNotFoundException exception) {

		log.warn("Employee not found: {}", exception.getMessage());

		return buildResponse(HttpStatus.NOT_FOUND, "Employee Not Found", exception.getMessage());
	}

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleDepartmentNotFound(DepartmentNotFoundException exception) {

		log.warn("Department not found: {}", exception.getMessage());

		return buildResponse(HttpStatus.NOT_FOUND, "Department Not Found", exception.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException exception) {

		log.warn("Request validation failed");

		Map<String, String> errors = new HashMap<>();

		exception.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		Map<String, Object> response = new HashMap<>();

		response.put("timestamp", LocalDateTime.now());
		response.put("status", HttpStatus.BAD_REQUEST.value());
		response.put("error", "Validation Failed");
		response.put("messages", errors);

		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(DataIntegrityViolationException exception) {

		log.warn("Database constraint violation occurred: {}", exception.getMessage());

		return buildResponse(HttpStatus.CONFLICT, "Database Constraint Violation",
				"Email or department name may already exist");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGeneralException(Exception exception) {

		log.error("Unexpected error occurred", exception);

		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", exception.getMessage());
	}

	private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String error, String message) {

		Map<String, Object> response = new HashMap<>();

		response.put("timestamp", LocalDateTime.now());
		response.put("status", status.value());
		response.put("error", error);
		response.put("message", message);

		return ResponseEntity.status(status).body(response);
	}
}