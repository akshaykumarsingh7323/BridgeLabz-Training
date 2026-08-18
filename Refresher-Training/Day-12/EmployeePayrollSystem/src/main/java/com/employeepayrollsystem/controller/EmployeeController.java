package com.employeepayrollsystem.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayrollsystem.dto.EmployeeRequestDto;
import com.employeepayrollsystem.dto.EmployeeResponseDto;
import com.employeepayrollsystem.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	// Logger
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	// CREATE

	@PostMapping
	public ResponseEntity<EmployeeResponseDto> addEmployee(@Valid @RequestBody EmployeeRequestDto requestDto) {

		log.info("Received request to create a new employee");

		EmployeeResponseDto response = employeeService.addEmployee(requestDto);

		log.info("Employee created successfully with id: {}", response.getId());

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// GET ALL + PAGINATION + SORTING

	@GetMapping
	public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployees(

			@RequestParam(defaultValue = "0") int page,

			@RequestParam(defaultValue = "10") int size,

			@RequestParam(defaultValue = "id") String sortBy,

			@RequestParam(defaultValue = "asc") String direction) {

		log.info("Received request to get all employees. Page: {}, Size: {}, SortBy: {}, Direction: {}", page, size,
				sortBy, direction);

		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

		Pageable pageable = PageRequest.of(page, size, sort);

		ResponseEntity<Page<EmployeeResponseDto>> response = ResponseEntity
				.ok(employeeService.getAllEmployees(pageable));

		log.info("Successfully fetched employees");

		return response;
	}

	// GET BY ID

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {

		log.info("Received request to get employee with id: {}", id);

		ResponseEntity<EmployeeResponseDto> response = ResponseEntity.ok(employeeService.getEmployeeById(id));

		log.info("Successfully fetched employee with id: {}", id);

		return response;
	}

	// UPDATE

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDto> updateEmployee(

			@PathVariable Long id,

			@Valid @RequestBody EmployeeRequestDto requestDto) {

		log.info("Received request to update employee with id: {}", id);

		ResponseEntity<EmployeeResponseDto> response = ResponseEntity
				.ok(employeeService.updateEmployee(id, requestDto));

		log.info("Employee updated successfully with id: {}", id);

		return response;
	}

	// DELETE

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

		log.info("Received request to delete employee with id: {}", id);

		employeeService.deleteEmployee(id);

		log.info("Employee deleted successfully with id: {}", id);

		return ResponseEntity.ok("Employee deleted successfully");
	}

	// QUERY BY EXAMPLE
	// + PAGINATION
	// + SORTING

	@GetMapping("/search")
	public ResponseEntity<Page<EmployeeResponseDto>> searchEmployees(

			@RequestParam(required = false) String name,

			@RequestParam(required = false) String email,

			@RequestParam(required = false) String phone,

			@RequestParam(required = false) Long departmentId,

			@RequestParam(required = false) String designation,

			@RequestParam(required = false) Double salary,

			@RequestParam(required = false) LocalDate joiningDate,

			@RequestParam(defaultValue = "0") int page,

			@RequestParam(defaultValue = "10") int size,

			@RequestParam(defaultValue = "id") String sortBy,

			@RequestParam(defaultValue = "asc") String direction) {

		log.info("Received employee search request. Page: {}, Size: {}, SortBy: {}, Direction: {}", page, size, sortBy,
				direction);

		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

		Pageable pageable = PageRequest.of(page, size, sort);

		ResponseEntity<Page<EmployeeResponseDto>> response = ResponseEntity.ok(employeeService.searchEmployees(

				name, email, phone, departmentId, designation, salary, joiningDate, pageable));

		log.info("Employee search completed successfully");

		return response;
	}
}