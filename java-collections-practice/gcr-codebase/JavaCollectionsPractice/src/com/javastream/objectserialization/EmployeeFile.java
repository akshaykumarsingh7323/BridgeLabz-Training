package com.javastream.objectserialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFile {

    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Akshay", "IT", 50000));
        employees.add(new Employee(102, "Rohit", "HR", 40000));
        employees.add(new Employee(103, "Amit", "Finance", 55000));

        serializeEmployees(employees);

        deserializeEmployees();
    }

    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeEmployees() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            List<Employee> empList = (List<Employee>) ois.readObject();

            System.out.println("\nEmployees read from file:");
            for (Employee e : empList) {
                System.out.println(e);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

