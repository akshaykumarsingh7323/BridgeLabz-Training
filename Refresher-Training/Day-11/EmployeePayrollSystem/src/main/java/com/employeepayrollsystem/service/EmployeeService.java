package com.employeepayrollsystem.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employeepayrollsystem.dto.EmployeeRequestDto;
import com.employeepayrollsystem.dto.EmployeeResponseDto;

public interface EmployeeService {

	EmployeeResponseDto addEmployee(EmployeeRequestDto requestDto);

	Page<EmployeeResponseDto> getAllEmployees(Pageable pageable);

	EmployeeResponseDto getEmployeeById(Long id);

	EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto);

	void deleteEmployee(Long id);

	Page<EmployeeResponseDto> searchEmployees(String name, String email, String phone, Long departmentId,
			String designation, Double salary, LocalDate joiningDate, Pageable pageable);
}