package com.employeepayrollsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeepayrollsystem.dto.DepartmentDTO;
import com.employeepayrollsystem.entity.Department;
import com.employeepayrollsystem.exception.DepartmentNotFoundException;
import com.employeepayrollsystem.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl
        implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository) {

        this.departmentRepository =
                departmentRepository;
    }

    @Override
    public DepartmentDTO addDepartment(
            DepartmentDTO departmentDTO) {

        Department department =
                new Department(
                        departmentDTO.getId(),
                        departmentDTO.getName(),
                        departmentDTO.getDescription()
                );

        Department savedDepartment =
                departmentRepository.save(department);

        return convertToDTO(savedDepartment);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public DepartmentDTO getDepartmentById(
            Long id) {

        Department department =
                departmentRepository.findById(id);

        if (department == null) {

            throw new DepartmentNotFoundException(
                    "Department with id "
                    + id
                    + " not found"
            );
        }

        return convertToDTO(department);
    }

    @Override
    public DepartmentDTO updateDepartment(
            Long id,
            DepartmentDTO departmentDTO) {

        Department existingDepartment =
                departmentRepository.findById(id);

        if (existingDepartment == null) {

            throw new DepartmentNotFoundException(
                    "Department with id "
                    + id
                    + " not found"
            );
        }

        Department department =
                new Department(
                        id,
                        departmentDTO.getName(),
                        departmentDTO.getDescription()
                );

        Department updatedDepartment =
                departmentRepository.update(
                        id,
                        department
                );

        return convertToDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department =
                departmentRepository.findById(id);

        if (department == null) {

            throw new DepartmentNotFoundException(
                    "Department with id "
                    + id
                    + " not found"
            );
        }

        departmentRepository.deleteById(id);
    }

    private DepartmentDTO convertToDTO(
            Department department) {

        return new DepartmentDTO(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }
}