package com.employeepayrollsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeepayrollsystem.dto.EmployeeDTO;
import com.employeepayrollsystem.entity.Employee;
import com.employeepayrollsystem.exception.DepartmentNotFoundException;
import com.employeepayrollsystem.exception.EmployeeNotFoundException;
import com.employeepayrollsystem.repository.DepartmentRepository;
import com.employeepayrollsystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl
        implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository) {

        this.employeeRepository =
                employeeRepository;

        this.departmentRepository =
                departmentRepository;
    }

    @Override
    public EmployeeDTO addEmployee(
            EmployeeDTO employeeDTO) {

        // Check department exists
        validateDepartment(
                employeeDTO.getDepartmentId()
        );

        Employee employee =
                convertToEntity(employeeDTO);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return convertToDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(
            Long id) {

        Employee employee =
                employeeRepository.findById(id);

        if (employee == null) {

            throw new EmployeeNotFoundException(
                    "Employee with id "
                    + id
                    + " not found"
            );
        }

        return convertToDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(
            Long id,
            EmployeeDTO employeeDTO) {

        Employee existingEmployee =
                employeeRepository.findById(id);

        if (existingEmployee == null) {

            throw new EmployeeNotFoundException(
                    "Employee with id "
                    + id
                    + " not found"
            );
        }

        // Check department exists
        validateDepartment(
                employeeDTO.getDepartmentId()
        );

        Employee employee =
                convertToEntity(employeeDTO);

        Employee updatedEmployee =
                employeeRepository.update(
                        id,
                        employee
                );

        return convertToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee =
                employeeRepository.findById(id);

        if (employee == null) {

            throw new EmployeeNotFoundException(
                    "Employee with id "
                    + id
                    + " not found"
            );
        }

        employeeRepository.deleteById(id);
    }

    private void validateDepartment(
            Long departmentId) {

        if (departmentRepository.findById(
                departmentId) == null) {

            throw new DepartmentNotFoundException(
                    "Department with id "
                    + departmentId
                    + " not found"
            );
        }
    }

    private Employee convertToEntity(
            EmployeeDTO dto) {

        return new Employee(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getDepartmentId(),
                dto.getDesignation(),
                dto.getSalary(),
                dto.getJoiningDate()
        );
    }

    private EmployeeDTO convertToDTO(
            Employee employee) {

        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDepartmentId(),
                employee.getDesignation(),
                employee.getSalary(),
                employee.getJoiningDate()
        );
    }
}