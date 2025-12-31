package com.staticandfinal.level1;

public class Company {
	   private static String companyName;
	   private static int totalEmployees = 0;
	   private String name;
	   private final int id; 
	   private String designation;
	   
	   public Company(String name, int id, String designation) {
	       this.name = name;
	       this.id = id;
	       this.designation = designation;
	       totalEmployees++;
	   }

	   public static void setCompanyName(String name) {
	       companyName = name;
	   }

	   public static void displayTotalEmployees() {
	       System.out.println("Total Employees: " + totalEmployees);
	   }

	   public void displayEmployeeDetails() {

		   if (this instanceof Company) {
	           System.out.println("\nCompany Name: " + companyName);
	           System.out.println("Employee ID: " + id);
	           System.out.println("Name: " + name);
	           System.out.println("Designation: " + designation);
	       } else {
	           System.out.println("The object is not an instance of the Employee class.");
	       }
	   }

	   public String getName() {
	       return name;
	   }
	   public int getId() {
	       return id;
	   }
	   public String getDesignation() {
	       return designation;
	   }
	}

