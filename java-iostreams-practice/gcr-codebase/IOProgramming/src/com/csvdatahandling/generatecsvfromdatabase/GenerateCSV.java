package com.csvdatahandling.generatecsvfromdatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateCSV {

    public static void main(String[] args) {

        String dbUrl = "jdbc:mysql://localhost:3306/companydb";
        String dbUser = "root";
        String dbPassword = "password";

        String csvFile = "employees_report.csv";

        String query = "SELECT emp_id, name, department, salary FROM employees";

        try (
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))
        ) {

            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                int salary = rs.getInt("salary");

                bw.write(id + "," + name + "," + department + "," + salary);
                bw.newLine();
            }

            System.out.println("CSV report generated successfully!");
            System.out.println("File: " + csvFile);

        } catch (Exception e) {
            System.out.println("Error generating CSV report.");
        }
    }
}
