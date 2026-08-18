package com.employeepayrollsystem.controller;

import java.time.LocalDate;

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

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	// CREATE

	@PostMapping
	public ResponseEntity<EmployeeResponseDto> addEmployee(@Valid @RequestBody EmployeeRequestDto requestDto) {

		EmployeeResponseDto response = employeeService.addEmployee(requestDto);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// GET ALL + PAGINATION + SORTING

	@GetMapping
	public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployees(

			@RequestParam(defaultValue = "0") int page,

			@RequestParam(defaultValue = "10") int size,

			@RequestParam(defaultValue = "id") String sortBy,

			@RequestParam(defaultValue = "asc") String direction) {

		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

		Pageable pageable = PageRequest.of(page, size, sort);

		return ResponseEntity.ok(employeeService.getAllEmployees(pageable));
	}

	// GET BY ID

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {

		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	// UPDATE

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDto> updateEmployee(

			@PathVariable Long id,

			@Valid @RequestBody EmployeeRequestDto requestDto) {

		return ResponseEntity.ok(employeeService.updateEmployee(id, requestDto));
	}

	// DELETE

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);

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

		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

		Pageable pageable = PageRequest.of(page, size, sort);

		return ResponseEntity.ok(employeeService.searchEmployees(

				name,

				email,

				phone,

				departmentId,

				designation,

				salary,

				joiningDate,

				pageable));
	}
}