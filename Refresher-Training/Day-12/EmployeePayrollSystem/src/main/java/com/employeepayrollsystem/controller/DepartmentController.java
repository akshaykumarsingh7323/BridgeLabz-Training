package com.employeepayrollsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayrollsystem.dto.DepartmentRequestDto;
import com.employeepayrollsystem.dto.DepartmentResponseDto;
import com.employeepayrollsystem.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	private final DepartmentService departmentService;

	// Logger
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

	public DepartmentController(DepartmentService departmentService) {

		this.departmentService = departmentService;
	}

	// CREATE

	@PostMapping
	public ResponseEntity<DepartmentResponseDto> addDepartment(@Valid @RequestBody DepartmentRequestDto requestDto) {

		log.info("Received request to create a new department");

		DepartmentResponseDto response = departmentService.addDepartment(requestDto);

		log.info("Department created successfully with id: {}", response.getId());

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// GET ALL

	@GetMapping
	public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {

		log.info("Received request to get all departments");

		List<DepartmentResponseDto> departments = departmentService.getAllDepartments();

		log.info("Successfully fetched all departments. Total: {}", departments.size());

		return ResponseEntity.ok(departments);
	}

	// GET BY ID

	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable Long id) {

		log.info("Received request to get department with id: {}", id);

		DepartmentResponseDto response = departmentService.getDepartmentById(id);

		log.info("Successfully fetched department with id: {}", id);

		return ResponseEntity.ok(response);
	}

	// UPDATE

	@PutMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable Long id,
			@Valid @RequestBody DepartmentRequestDto requestDto) {

		log.info("Received request to update department with id: {}", id);

		DepartmentResponseDto response = departmentService.updateDepartment(id, requestDto);

		log.info("Department updated successfully with id: {}", id);

		return ResponseEntity.ok(response);
	}

	// DELETE

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {

		log.info("Received request to delete department with id: {}", id);

		departmentService.deleteDepartment(id);

		log.info("Department deleted successfully with id: {}", id);

		return ResponseEntity.ok("Department deleted successfully");
	}
}