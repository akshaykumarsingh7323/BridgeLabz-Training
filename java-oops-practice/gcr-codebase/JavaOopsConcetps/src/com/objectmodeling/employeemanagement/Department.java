package com.objectmodeling.employeemanagement;

import java.util.*;

class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
        System.out.println("Department created: " + deptName);
    }

    public void addEmployee(int id, String name) {
        employees.add(new Employee(id, name));
    }

    public void showEmployees() {
        System.out.println(" Department: " + deptName);
        for (Employee e : employees) {
            e.display();
        }
    }

    // Called when company is deleted
    public void destroy() {
        for (Employee e : employees) {
            e.destroy();
        }
        employees.clear();
        System.out.println("Department destroyed: " + deptName);
    }
}

