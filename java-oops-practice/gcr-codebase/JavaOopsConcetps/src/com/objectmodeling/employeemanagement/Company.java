package com.objectmodeling.employeemanagement;

import java.util.*;

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
        System.out.println("Company created: " + companyName);
    }

    public Department addDepartment(String name) {
        Department dept = new Department(name);
        departments.add(dept);
        return dept;
    }

    public void showCompanyDetails() {
        System.out.println("\nCompany: " + companyName);
        for (Department d : departments) {
            d.showEmployees();
        }
    }

    // Composition proof
    public void destroyCompany() {
        for (Department d : departments) {
            d.destroy();
        }
        departments.clear();
        System.out.println("Company destroyed: " + companyName);
    }
}

