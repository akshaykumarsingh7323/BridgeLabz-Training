package com.employeepayrollsystem.service;

import java.time.LocalDate;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employeepayrollsystem.dto.EmployeeRequestDto;
import com.employeepayrollsystem.dto.EmployeeResponseDto;
import com.employeepayrollsystem.entity.Department;
import com.employeepayrollsystem.entity.Employee;
import com.employeepayrollsystem.exception.DepartmentNotFoundException;
import com.employeepayrollsystem.exception.EmployeeNotFoundException;
import com.employeepayrollsystem.repository.DepartmentRepository;
import com.employeepayrollsystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	private final DepartmentRepository departmentRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {

		this.employeeRepository = employeeRepository;

		this.departmentRepository = departmentRepository;
	}

	// CREATE

	@Override
	public EmployeeResponseDto addEmployee(EmployeeRequestDto requestDto) {

		Department department = getDepartment(requestDto.getDepartmentId());

		Employee employee = new Employee();

		employee.setName(requestDto.getName());

		employee.setEmail(requestDto.getEmail());

		employee.setPhone(requestDto.getPhone());

		employee.setDepartment(department);

		employee.setDesignation(requestDto.getDesignation());

		employee.setSalary(requestDto.getSalary());

		employee.setJoiningDate(requestDto.getJoiningDate());

		Employee savedEmployee = employeeRepository.save(employee);

		return convertToResponseDto(savedEmployee);
	}

	// GET ALL

	@Override
	public Page<EmployeeResponseDto> getAllEmployees(Pageable pageable) {

		Page<Employee> employeePage = employeeRepository.findAll(pageable);

		return employeePage.map(this::convertToResponseDto);
	}

	// GET BY ID

	@Override
	public EmployeeResponseDto getEmployeeById(Long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));

		return convertToResponseDto(employee);
	}

	// UPDATE

	@Override
	public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));

		Department department = getDepartment(requestDto.getDepartmentId());

		employee.setName(requestDto.getName());

		employee.setEmail(requestDto.getEmail());

		employee.setPhone(requestDto.getPhone());

		employee.setDepartment(department);

		employee.setDesignation(requestDto.getDesignation());

		employee.setSalary(requestDto.getSalary());

		employee.setJoiningDate(requestDto.getJoiningDate());

		Employee updatedEmployee = employeeRepository.save(employee);

		return convertToResponseDto(updatedEmployee);
	}

	// DELETE

	@Override
	public void deleteEmployee(Long id) {

		if (!employeeRepository.existsById(id)) {

			throw new EmployeeNotFoundException("Employee with id " + id + " not found");
		}

		employeeRepository.deleteById(id);
	}

	// QUERY BY EXAMPLE

	@Override
	public Page<EmployeeResponseDto> searchEmployees(String name, String email, String phone, Long departmentId,
			String designation, Double salary, LocalDate joiningDate, Pageable pageable) {

		Employee employee = new Employee();

		employee.setName(name);

		employee.setEmail(email);

		employee.setPhone(phone);

		employee.setDesignation(designation);

		employee.setSalary(salary);

		employee.setJoiningDate(joiningDate);

		if (departmentId != null) {

			Department department = new Department();

			department.setId(departmentId);

			employee.setDepartment(department);
		}

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

		Example<Employee> example = Example.of(employee, matcher);

		Page<Employee> employeePage = employeeRepository.findAll(example, pageable);

		return employeePage.map(this::convertToResponseDto);
	}

	private Department getDepartment(Long departmentId) {

		return departmentRepository.findById(departmentId).orElseThrow(
				() -> new DepartmentNotFoundException("Department with id " + departmentId + " not found"));
	}

	private EmployeeResponseDto convertToResponseDto(Employee employee) {

		return new EmployeeResponseDto(

				employee.getId(),

				employee.getName(),

				employee.getEmail(),

				employee.getPhone(),

				employee.getDepartment().getId(),

				employee.getDepartment().getName(),

				employee.getDesignation(),

				employee.getSalary(),

				employee.getJoiningDate());
	}
}