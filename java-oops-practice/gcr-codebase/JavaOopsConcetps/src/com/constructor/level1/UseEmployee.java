package com.constructor.level1;

public class UseEmployee {
	public static void main(String[] args) {
        Manager m = new Manager(101, "IT", 75000, "Project Manager");

        m.displayManagerDetails();

        m.setSalary(85000);
        System.out.println("Updated Salary: Rs " + m.getSalary());
    }
}
