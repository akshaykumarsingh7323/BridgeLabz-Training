package com.employee;

public class Employee {
		int id;
		String name;
		int age;
		String gender;
		String department;
		int yearOfJoining;
		double salary;
		public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.department = department;
			this.yearOfJoining = yearOfJoining;
			this.salary = salary;
		}
		
		
		int getId() {
			return id;
		}


		String getName() {
			return name;
		}


		int getAge() {
			return age;
		}


		String getGender() {
			return gender;
		}


		String getDepartment() {
			return department;
		}


		int getYearOfJoining() {
			return yearOfJoining;
		}


		double getSalary() {
			return salary;
		}


		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
					+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
		}	
}
