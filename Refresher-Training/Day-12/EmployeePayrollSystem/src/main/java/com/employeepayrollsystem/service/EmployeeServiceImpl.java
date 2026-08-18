package com.employeepayrollsystem.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	// Logger
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {

		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	// CREATE
	@Override
	public EmployeeResponseDto addEmployee(EmployeeRequestDto requestDto) {

		log.info("Creating new employee with email: {}", requestDto.getEmail());

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

		log.info("Employee created successfully with id: {}", savedEmployee.getId());

		return convertToResponseDto(savedEmployee);
	}

	// GET ALL
	@Override
	public Page<EmployeeResponseDto> getAllEmployees(Pageable pageable) {

		log.info("Fetching all employees. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());

		Page<Employee> employeePage = employeeRepository.findAll(pageable);

		log.info("Total employees found: {}", employeePage.getTotalElements());

		return employeePage.map(this::convertToResponseDto);
	}

	// GET BY ID
	@Override
	public EmployeeResponseDto getEmployeeById(Long id) {

		log.info("Fetching employee with id: {}", id);

		Employee employee = employeeRepository.findById(id).orElseThrow(() -> {

			log.error("Employee not found with id: {}", id);

			return new EmployeeNotFoundException("Employee with id " + id + " not found");
		});

		log.info("Employee found successfully with id: {}", id);

		return convertToResponseDto(employee);
	}

	// UPDATE
	@Override
	public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto) {

		log.info("Updating employee with id: {}", id);

		Employee employee = employeeRepository.findById(id).orElseThrow(() -> {

			log.error("Employee not found for update with id: {}", id);

			return new EmployeeNotFoundException("Employee with id " + id + " not found");
		});

		Department department = getDepartment(requestDto.getDepartmentId());

		employee.setName(requestDto.getName());
		employee.setEmail(requestDto.getEmail());
		employee.setPhone(requestDto.getPhone());
		employee.setDepartment(department);
		employee.setDesignation(requestDto.getDesignation());
		employee.setSalary(requestDto.getSalary());
		employee.setJoiningDate(requestDto.getJoiningDate());

		Employee updatedEmployee = employeeRepository.save(employee);

		log.info("Employee updated successfully with id: {}", id);

		return convertToResponseDto(updatedEmployee);
	}

	// DELETE
	@Override
	public void deleteEmployee(Long id) {

		log.info("Deleting employee with id: {}", id);

		if (!employeeRepository.existsById(id)) {

			log.error("Employee not found for deletion with id: {}", id);

			throw new EmployeeNotFoundException("Employee with id " + id + " not found");
		}

		employeeRepository.deleteById(id);

		log.info("Employee deleted successfully with id: {}", id);
	}

	// QUERY BY EXAMPLE
	@Override
	public Page<EmployeeResponseDto> searchEmployees(String name, String email, String phone, Long departmentId,
			String designation, Double salary, LocalDate joiningDate, Pageable pageable) {

		log.info("Searching employees with filters - name: {}, email: {}, departmentId: {}, designation: {}", name,
				email, departmentId, designation);

		Employee employee = new Employee();

		employee.setName(name);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setDesignation(designation);
		employee.setSalary(salary);
		employee.setJoiningDate(joiningDate);

		if (departmentId != null) {

			log.debug("Searching employees for department id: {}", departmentId);

			Department department = new Department();
			department.setId(departmentId);

			employee.setDepartment(department);
		}

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

		Example<Employee> example = Example.of(employee, matcher);

		Page<Employee> employeePage = employeeRepository.findAll(example, pageable);

		log.info("Employee search completed. Total results: {}", employeePage.getTotalElements());

		return employeePage.map(this::convertToResponseDto);
	}

	private Department getDepartment(Long departmentId) {

		log.info("Fetching department with id: {}", departmentId);

		return departmentRepository.findById(departmentId).orElseThrow(() -> {

			log.error("Department not found with id: {}", departmentId);

			return new DepartmentNotFoundException("Department with id " + departmentId + " not found");
		});
	}

	private EmployeeResponseDto convertToResponseDto(Employee employee) {

		log.debug("Converting employee entity to response DTO. Employee id: {}", employee.getId());

		return new EmployeeResponseDto(employee.getId(), employee.getName(), employee.getEmail(), employee.getPhone(),
				employee.getDepartment().getId(), employee.getDepartment().getName(), employee.getDesignation(),
				employee.getSalary(), employee.getJoiningDate());
	}
}