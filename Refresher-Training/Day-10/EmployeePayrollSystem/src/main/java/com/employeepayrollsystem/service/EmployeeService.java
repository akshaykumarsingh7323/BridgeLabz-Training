package com.employeepayrollsystem.service;

import java.util.List;

import com.employeepayrollsystem.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO addEmployee(
            EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO updateEmployee(
            Long id,
            EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}