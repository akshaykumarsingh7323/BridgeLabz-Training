package com.employeepayrollsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.employeepayrollsystem.dto.DepartmentRequestDto;
import com.employeepayrollsystem.dto.DepartmentResponseDto;
import com.employeepayrollsystem.entity.Department;
import com.employeepayrollsystem.exception.DepartmentNotFoundException;
import com.employeepayrollsystem.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;

	// Logger
	private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {

		this.departmentRepository = departmentRepository;
	}

	// CREATE
	@Override
	public DepartmentResponseDto addDepartment(DepartmentRequestDto requestDto) {

		log.info("Creating new department with name: {}", requestDto.getName());

		Department department = new Department();

		department.setName(requestDto.getName());
		department.setDescription(requestDto.getDescription());

		Department saved = departmentRepository.save(department);

		log.info("Department created successfully with id: {}", saved.getId());

		return convertToResponse(saved);
	}

	// GET ALL
	@Override
	public List<DepartmentResponseDto> getAllDepartments() {

		log.info("Fetching all departments");

		List<DepartmentResponseDto> departments = departmentRepository.findAll().stream().map(this::convertToResponse)
				.toList();

		log.info("Total departments found: {}", departments.size());

		return departments;
	}

	// GET BY ID
	@Override
	public DepartmentResponseDto getDepartmentById(Long id) {

		log.info("Fetching department with id: {}", id);

		Department department = departmentRepository.findById(id).orElseThrow(() -> {

			log.error("Department not found with id: {}", id);

			return new DepartmentNotFoundException("Department with id " + id + " not found");
		});

		log.info("Department found successfully with id: {}", id);

		return convertToResponse(department);
	}

	// UPDATE
	@Override
	public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto requestDto) {

		log.info("Updating department with id: {}", id);

		Department department = departmentRepository.findById(id).orElseThrow(() -> {

			log.error("Department not found for update with id: {}", id);

			return new DepartmentNotFoundException("Department with id " + id + " not found");
		});

		department.setName(requestDto.getName());
		department.setDescription(requestDto.getDescription());

		Department updated = departmentRepository.save(department);

		log.info("Department updated successfully with id: {}", id);

		return convertToResponse(updated);
	}

	// DELETE
	@Override
	public void deleteDepartment(Long id) {

		log.info("Deleting department with id: {}", id);

		Department department = departmentRepository.findById(id).orElseThrow(() -> {

			log.error("Department not found for deletion with id: {}", id);

			return new DepartmentNotFoundException("Department with id " + id + " not found");
		});

		departmentRepository.delete(department);

		log.info("Department deleted successfully with id: {}", id);
	}

	private DepartmentResponseDto convertToResponse(Department department) {

		log.debug("Converting department entity to response DTO. Department id: {}", department.getId());

		return new DepartmentResponseDto(department.getId(), department.getName(), department.getDescription());
	}
}