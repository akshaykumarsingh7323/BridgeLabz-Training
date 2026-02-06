package com.java8conversion.listtomapconversion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//3.Convert List of employees to Map with id as key and name as value
class Employee{
	int id;
	String name;
	String department;
	int age;
	
	public Employee(int id, String name, String department, int age) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.age = age;
		
		
	}

	int getId() {
		return id;
	}

	String getName() {
		return name;
	}

	String getDepartment() {
		return department;
	}

	int getAge() {
		return age;
	}
	
	
}
public class EmployeeToMap {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
		        new Employee(101, "Amit", "IT", 25),
		        new Employee(102, "Rohit", "HR", 30),
		        new Employee(103, "Neha", "Finance", 28),
		        new Employee(104, "Priya", "IT", 26),
		        new Employee(105, "Suman", "Marketing", 32)
		);
		
		Map<Integer, String> student = employees.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println(student);
	}
}
