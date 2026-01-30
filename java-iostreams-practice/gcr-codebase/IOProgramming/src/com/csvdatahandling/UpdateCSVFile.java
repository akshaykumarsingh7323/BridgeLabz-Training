package com.csvdatahandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSVFile {

    public static void main(String[] args) {

        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";

        String line;

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            bw.write(br.readLine());
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }

                bw.write(id + "," + name + "," + department + "," + (int) salary);
                bw.newLine();
            }

            System.out.println("Salary updated successfully. New CSV created.");

        } catch (IOException e) {
            System.out.println("Error processing CSV file.");
        }
    }
}

