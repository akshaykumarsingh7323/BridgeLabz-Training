package com.csvdatahandling.mergecsvfile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "students_merged.csv";

        Map<Integer, Student> studentMap = new HashMap<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {

            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                studentMap.put(id, new Student(id, name, age));
            }

        } catch (IOException e) {
            System.out.println("Error reading students1.csv");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {

            br.readLine(); 						

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                int marks = Integer.parseInt(data[1]);
                String grade = data[2];

                Student student = studentMap.get(id);
                if (student != null) {
                    student.marks = marks;
                    student.grade = grade;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading students2.csv");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (Student s : studentMap.values()) {
                bw.write(s.id + "," + s.name + "," + s.age + "," + s.marks + "," + s.grade);
                bw.newLine();
            }

            System.out.println("CSV files merged successfully!");
            System.out.println("Output file: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing merged CSV");
        }
    }
}
