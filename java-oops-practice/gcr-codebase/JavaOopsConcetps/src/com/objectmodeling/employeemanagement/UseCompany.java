package com.objectmodeling.employeemanagement;

public class UseCompany {
    public static void main(String[] args) {

        Company company = new Company("TechNova");

        Department it = company.addDepartment("IT");
        it.addEmployee(1, "Akshay");
        it.addEmployee(2, "Rohan");

        Department hr = company.addDepartment("HR");
        hr.addEmployee(3, "Neha");

        company.showCompanyDetails();

        System.out.println("\n--- Deleting Company ---");
        company.destroyCompany();
    }
}

