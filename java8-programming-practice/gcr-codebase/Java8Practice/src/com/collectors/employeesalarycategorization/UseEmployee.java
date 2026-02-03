package com.collectors.employeesalarycategorization;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseEmployee {
	public static void main(String[] args) {
		List<Employee> employees = List.of(
		        new Employee(101, "Akshay", "IT", 65000),
		        new Employee(102, "Rahul", "HR", 45000),
		        new Employee(103, "Neha", "IT", 72000),
		        new Employee(104, "Pooja", "Finance", 80000),
		        new Employee(105, "Amit", "HR", 50000),
		        new Employee(106, "Sneha", "Finance", 75000),
		        new Employee(107, "Vikas", "IT", 68000)
		);
	Map<String, Double> averageSal = employees.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, 
					Collectors.averagingDouble(Employee::getSalary)));	
	
	averageSal.forEach((k, v) ->
    System.out.println(k + " -> " + v));
	}
}
