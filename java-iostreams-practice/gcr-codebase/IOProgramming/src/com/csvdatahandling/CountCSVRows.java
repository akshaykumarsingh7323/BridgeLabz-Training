package com.csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {

    public static void main(String[] args) {

        String filePath = "src/com/csvdatahandling/ReadCSVFile.java";
        int recordCount = 0;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { 
                    recordCount++;
                }
            }

            System.out.println("Total Records (excluding header): " + recordCount);

        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
        }
    }
}
