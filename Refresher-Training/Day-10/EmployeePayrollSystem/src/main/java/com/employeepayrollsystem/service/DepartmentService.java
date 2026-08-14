package com.employeepayrollsystem.service;

import java.util.List;

import com.employeepayrollsystem.dto.DepartmentDTO;

public interface DepartmentService {

    DepartmentDTO addDepartment(
            DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentById(Long id);

    DepartmentDTO updateDepartment(
            Long id,
            DepartmentDTO departmentDTO);

    void deleteDepartment(Long id);
}