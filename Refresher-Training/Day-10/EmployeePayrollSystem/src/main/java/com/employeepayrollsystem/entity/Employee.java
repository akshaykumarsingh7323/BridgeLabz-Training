package com.employeepayrollsystem.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private Long departmentId;

    private String designation;

    private double salary;

    private LocalDate joiningDate;
}