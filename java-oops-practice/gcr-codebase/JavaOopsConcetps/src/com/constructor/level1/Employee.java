package com.constructor.level1;

public class Employee {

    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be positive!");
        }
    }

    void displayEmployee() {
        System.out.println(
            "Employee ID: " + employeeID +
            ", Department: " + department +
            ", Salary: Rs " + salary
        );
    }
}


class Manager extends Employee {

    String role;

    Manager(int employeeID, String department, double salary, String role) {
        super(employeeID, department, salary);
        this.role = role;
    }

    void displayManagerDetails() {
        System.out.println(
            "Employee ID: " + employeeID +  
            ", Department: " + department +  
            ", Role: " + role +
            ", Salary: Rs" + getSalary()  
        );
    }
}
