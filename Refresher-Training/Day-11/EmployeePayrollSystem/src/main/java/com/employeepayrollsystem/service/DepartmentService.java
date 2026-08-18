package com.employeepayrollsystem.service;

import java.util.List;

import com.employeepayrollsystem.dto.DepartmentRequestDto;
import com.employeepayrollsystem.dto.DepartmentResponseDto;

public interface DepartmentService {

	DepartmentResponseDto addDepartment(DepartmentRequestDto requestDto);

	List<DepartmentResponseDto> getAllDepartments();

	DepartmentResponseDto getDepartmentById(Long id);

	DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto requestDto);

	void deleteDepartment(Long id);
}