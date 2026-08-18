package com.employeepayrollsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeepayrollsystem.dto.DepartmentRequestDto;
import com.employeepayrollsystem.dto.DepartmentResponseDto;
import com.employeepayrollsystem.entity.Department;
import com.employeepayrollsystem.exception.DepartmentNotFoundException;
import com.employeepayrollsystem.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {

		this.departmentRepository = departmentRepository;
	}

	@Override
	public DepartmentResponseDto addDepartment(DepartmentRequestDto requestDto) {

		Department department = new Department();

		department.setName(requestDto.getName());

		department.setDescription(requestDto.getDescription());

		Department saved = departmentRepository.save(department);

		return convertToResponse(saved);
	}

	@Override
	public List<DepartmentResponseDto> getAllDepartments() {

		return departmentRepository.findAll().stream().map(this::convertToResponse).toList();
	}

	@Override
	public DepartmentResponseDto getDepartmentById(Long id) {

		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department with id " + id + " not found"));

		return convertToResponse(department);
	}

	@Override
	public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto requestDto) {

		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department with id " + id + " not found"));

		department.setName(requestDto.getName());

		department.setDescription(requestDto.getDescription());

		Department updated = departmentRepository.save(department);

		return convertToResponse(updated);
	}

	@Override
	public void deleteDepartment(Long id) {

		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department with id " + id + " not found"));

		departmentRepository.delete(department);
	}

	private DepartmentResponseDto convertToResponse(Department department) {

		return new DepartmentResponseDto(department.getId(), department.getName(), department.getDescription());
	}
}