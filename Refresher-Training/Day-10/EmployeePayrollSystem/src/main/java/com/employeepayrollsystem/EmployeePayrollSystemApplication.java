package com.employeepayrollsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePayrollSystemApplication {

    public static void main(String[] args) {
    	System.out.println("Application started successfully");

        SpringApplication.run(EmployeePayrollSystemApplication.class, args);
    }
}