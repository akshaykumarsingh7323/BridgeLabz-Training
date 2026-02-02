package com.employee;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class UseEmployee {
	public static void main(String[] args) {
		List<Employee> employees = List.of(
			    new Employee(1, "Akshay", 25, "Male", "IT", 2022, 55000),
			    new Employee(2, "Neha", 28, "Female", "HR", 2020, 48000),
			    new Employee(3, "Rohit", 32, "Male", "Finance", 2018, 65000),
			    new Employee(4, "Sneha", 26, "Female", "IT", 2021, 52000),
			    new Employee(5, "Amit", 35, "Male", "Sales", 2016, 70000),
			    new Employee(6, "Pooja", 29, "Female", "Marketing", 2019, 50000),
			    new Employee(7, "Vikram", 41, "Male", "PD", 2012, 82000),
			    new Employee(8, "Riya", 24, "Female", "IT", 2023, 45000),
			    new Employee(9, "Suresh", 38, "Male", "Finance", 2014, 78000),
			    new Employee(10, "Anjali", 31, "Female", "Sales", 2017, 62000)
			);
		
//		1. How many male and female employees are there in the organization ?
		System.out.println("1. Male & Female Count:");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
        );
		
//		2. Print the name of all departments in the organization ?
        System.out.println("\n2. Departments:");
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
//		3. What is the average age of male and female employees ?
        System.out.println("\n3. Average age by gender:");
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)))
        );
		
//		4. Get the details of highest paid employee in the organization ?
        System.out.println("\n4. Highest paid employee:");
        System.out.println(employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get());
		
//		5. Get the names of all employees who have joined after 2015 ?
        System.out.println("\n5. Joined after 2015:");
        employees.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		
//		6. Count the number of employees in each department ?
        System.out.println("\n6. Count by department:");
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
		
//		7. What is the average salary of each department ?
        System.out.println("\n7. Average salary by department:");
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))));
		
//		8. Get the details of youngest male employee in the product development department ?
        System.out.println("\n8. Youngest male in PD:");
        System.out.println(employees.stream().filter(e -> e.getGender().equalsIgnoreCase("Male"))
        		.filter(e -> e.getDepartment().toUpperCase().equalsIgnoreCase("PD"))
                        .min(Comparator.comparingInt(Employee::getAge))
                        .orElse(null)
        );
		
//		9. Who has the most working experience in the organization?
        System.out.println("\n9. Most experienced employee:");
        System.out.println(employees.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get());
		
//		10. How many male and female employees are there in the Sales team?
        System.out.println(employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Sales"))
        		.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		
//		11. What is the average salary of male and female employees ?
        System.out.println("\n11. Average salary by gender:");
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))
        );
		
//		12. List down the names of all employees in each department ?
        System.out.println("\n12. Employees by department:");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors
        		.mapping(Employee::getName, Collectors.toList()))).forEach((k, v) -> System.out.println(k + " : " + v));
		
//		13. What is the average salary and total salary of the whole organization?
        System.out.println("\n13. Average & Total salary:");
        DoubleSummaryStatistics stats = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("sum, average, count, min, max, ...  " + stats);
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Total: " + stats.getSum());
		
//		14. Get the employee whose salary are more than 25k.
        System.out.println("\n14. Salary > 25k:");
        employees.stream().filter(e -> e.getSalary() > 25000).forEach(System.out::println);
		
//		15.Who is the highest paid employee in the organization?
        System.out.println("\n15 Highest paid:");
        List<Employee> sorted = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
        System.out.println("Highest paid: " + sorted.get(sorted.size() - 1));
		
//		16.Who is the second highest paid employee in the organization?
        System.out.println("\n16 Second Highest paid:");
        System.out.println("Second highest: " + sorted.get(sorted.size() - 2));
		
//		17.Who is the third highest paid employee in the organization?
        System.out.println("\n17 Third Highest paid:");
        System.out.println("Third highest: " + sorted.get(sorted.size() - 3));
		
//		18.Who is the lowest paid employee in the organization?
        System.out.println("\n18 Lowest paid:");
        System.out.println("Lowest paid: " + sorted.get(0));
		
//		19.Who is the second lowest paid employee in the organization?
        System.out.println("19. Second lowest: " + sorted.get(1));
		
//		20.Get the first five lowest paid employee in the organization?
        System.out.println("\n20. First five lowest paid:");
        sorted.stream().limit(5).forEach(System.out::println);
		
//		21.Get the first five highest paid employee in the organization?
        System.out.println("\n21. First five highest paid:");
        sorted.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(5).forEach(System.out::println);
		
	}
}
