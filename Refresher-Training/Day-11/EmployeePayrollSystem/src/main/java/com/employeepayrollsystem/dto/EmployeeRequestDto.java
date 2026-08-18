package com.employeepayrollsystem.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Phone is required")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid phone number")
	private String phone;

	@NotNull(message = "Department is required")
	@Positive(message = "Department ID must be positive")
	private Long departmentId;

	@NotBlank(message = "Designation is required")
	private String designation;

	@NotNull(message = "Salary is required")
	@Positive(message = "Salary must be greater than zero")
	private Double salary;

	@NotNull(message = "Joining date is required")
	private LocalDate joiningDate;
}