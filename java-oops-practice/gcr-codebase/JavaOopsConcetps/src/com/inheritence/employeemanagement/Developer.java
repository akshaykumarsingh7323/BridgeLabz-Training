package com.inheritence.employeemanagement;

public class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Language  : " + programmingLanguage);
        System.out.println("Role      : Developer");
    }
}
