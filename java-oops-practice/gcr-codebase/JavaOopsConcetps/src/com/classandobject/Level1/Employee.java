package com.classandobject.Level1;


// create a Employee class to show details of employee
public class Employee {
	
	 String name;
	 int id;
	 double salary;
	 
	 // constructor 
	 Employee(String name, int id, double salary){
		 this.name=name;
		 this.id=id;
		 this.salary=salary;
	 }
	
	 //mehtod to display details
	public void displayDetails() {
		System.out.println("Employee Name: " + name);
		System.out.println("Employee id: " + id);
		System.out.println("Employee Salary: " + salary);
	}

	public static void main(String[] args) {
		Employee emp = new Employee("Akshay", 1, 450000.0);
		emp.displayDetails();
	}

}
