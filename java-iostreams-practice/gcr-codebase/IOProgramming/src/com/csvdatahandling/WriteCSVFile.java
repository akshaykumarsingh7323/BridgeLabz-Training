package com.csvdatahandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {

    public static void main(String[] args) {

        String filePath = "employees.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write("ID,Name,Department,Salary");
            bw.newLine();

            bw.write("1,Amit,IT,55000");
            bw.newLine();

            bw.write("2,Riya,HR,48000");
            bw.newLine();

            bw.write("3,Rahul,Finance,60000");
            bw.newLine();

            bw.write("4,Priya,Marketing,52000");
            bw.newLine();

            bw.write("5,Karan,Sales,50000");
            bw.newLine();
            
            bw.write("6,AKshay,Software,70000");
            bw.newLine();

            System.out.println("Employee data written successfully to CSV file.");

        } catch (IOException e) {
            System.out.println("Error writing to the CSV file.");
            e.printStackTrace();
        }
    }
}
