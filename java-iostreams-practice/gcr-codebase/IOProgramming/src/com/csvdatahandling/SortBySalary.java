package com.csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    int id;
    String name;
    String department;
    int salary;

    Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class SortBySalary {

    public static void main(String[] args) {

        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String dept = data[2];
                int salary = Integer.parseInt(data[3]);

                employees.add(new Employee(id, name, dept, salary));
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file.");
            return;
        }

        employees.sort(Comparator.comparingInt((Employee e) -> e.salary).reversed());

        System.out.println("Top 5 Highest Paid Employees:");
        System.out.println("--------------------------------");

        int limit = Math.min(5, employees.size());
        for (int i = 0; i < limit; i++) {
            Employee e = employees.get(i);
            System.out.println("ID    : " + e.id);
            System.out.println("Name  : " + e.name);
            System.out.println("Dept  : " + e.department);
            System.out.println("Salary: " + e.salary);
            System.out.println("--------------------------------");
        }
    }
}

