package com.csvdatahandling.duplicatedetection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicate {

    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;

        Set<Integer> seenIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            System.out.println("Duplicate Records:");
            System.out.println("--------------------------------");

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                if (data.length < 1) continue;

                int id = Integer.parseInt(data[0]);

                if (!seenIds.add(id)) { 
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file.");
        }
    }
}

