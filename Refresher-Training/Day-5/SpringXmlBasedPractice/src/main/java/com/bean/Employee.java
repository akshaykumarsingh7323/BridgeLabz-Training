package com.bean;

public class Employee {

    private int id;
    private String name;
    private String department;
    
    public Employee(int id, String name, String department) {
    	this.id = id;
    	this.name = name;
    	this.department = department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    public void display() {
        System.out.println("Employee Id : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Department Name : " + department);
    }
}