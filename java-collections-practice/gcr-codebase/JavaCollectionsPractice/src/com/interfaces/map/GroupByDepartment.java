package com.interfaces.map;

import java.util.*;

public class GroupByDepartment {

    static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee emp : employees) {
            String dept = emp.getDepartment();

            if (!departmentMap.containsKey(dept)) {
                departmentMap.put(dept, new ArrayList<>());
            }
            departmentMap.get(dept).add(emp);
        }

        System.out.println(departmentMap);
    }
}




