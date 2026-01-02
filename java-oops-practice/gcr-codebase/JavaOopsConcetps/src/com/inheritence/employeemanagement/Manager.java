package com.inheritence.employeemanagement;

public class Manager extends Employee {
	int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size : " + teamSize);
        System.out.println("Role      : Manager");
    }
}
