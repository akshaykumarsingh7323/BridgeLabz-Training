package com.employeepayrollsystem.controller;

import java.util.List;

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

	public DepartmentController(DepartmentService departmentService) {

		this.departmentService = departmentService;
	}

	// CREATE

	@PostMapping
	public ResponseEntity<DepartmentResponseDto> addDepartment(@Valid @RequestBody DepartmentRequestDto requestDto) {

		return new ResponseEntity<>(departmentService.addDepartment(requestDto), HttpStatus.CREATED);
	}

	// GET ALL

	@GetMapping
	public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {

		return ResponseEntity.ok(departmentService.getAllDepartments());
	}

	// GET BY ID

	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable Long id) {

		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}

	// UPDATE

	@PutMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable Long id,
			@Valid @RequestBody DepartmentRequestDto requestDto) {

		return ResponseEntity.ok(departmentService.updateDepartment(id, requestDto));
	}

	// DELETE

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {

		departmentService.deleteDepartment(id);

		return ResponseEntity.ok("Department deleted successfully");
	}
}