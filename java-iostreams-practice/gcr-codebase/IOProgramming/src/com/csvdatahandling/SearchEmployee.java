package com.csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter path: ");
        String filePath = sc.nextLine();
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine().trim();

        boolean found = false;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[1];

                if (name.equalsIgnoreCase(searchName)) {
                    String department = data[2];
                    String salary = data[3];

                    System.out.println("\nEmployee Found!");
                    System.out.println("Name       : " + name);
                    System.out.println("Department : " + department);
                    System.out.println("Salary     : " + salary);

                    found = true;
                    break;
                    
                }
            }

            if (!found) {
                System.out.println("\nEmployee not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

