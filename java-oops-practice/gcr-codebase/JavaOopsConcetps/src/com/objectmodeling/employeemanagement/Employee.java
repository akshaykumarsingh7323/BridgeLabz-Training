package com.objectmodeling.employeemanagement;

class Employee {
    private int empId;
    private String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
        System.out.println("Employee created: " + name);
    }

    public void display() {
        System.out.println("   Employee ID: " + empId + ", Name: " + name);
    }

    // Called when department is removed
    public void destroy() {
        System.out.println("Employee destroyed: " + name);
    }
}

