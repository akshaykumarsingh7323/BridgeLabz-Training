package com.encapsulation.employeemanagementsystem;

import java.util.*;

public class UseEmployee {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        Employee e1 = new FullTimeEmployee(101, "Rohit", 50000);
        Employee e2 = new PartTimeEmployee(102, "Anjali", 80, 500);

        e1.assignDepartment("IT");
        e2.assignDepartment("HR");

        employees.add(e1);
        employees.add(e2);

        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
