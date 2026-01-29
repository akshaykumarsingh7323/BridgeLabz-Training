package com.csvdatahandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadCSVFile {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter path: ");

        String filePath = sc.nextLine();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            System.out.println("Student Details:");
            System.out.println("-----------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                System.out.println("ID    : " + id);
                System.out.println("Name  : " + name);
                System.out.println("Age   : " + age);
                System.out.println("Marks : " + marks);
                System.out.println("-----------------------------");
            }

        }catch(FileNotFoundException e) {
        	System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    }
}
