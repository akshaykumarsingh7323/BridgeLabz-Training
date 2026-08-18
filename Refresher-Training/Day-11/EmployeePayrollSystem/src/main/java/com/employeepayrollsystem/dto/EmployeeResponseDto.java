package com.employeepayrollsystem.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

	private Long id;

	private String name;

	private String email;

	private String phone;

	private Long departmentId;

	private String departmentName;

	private String designation;

	private Double salary;

	private LocalDate joiningDate;
}