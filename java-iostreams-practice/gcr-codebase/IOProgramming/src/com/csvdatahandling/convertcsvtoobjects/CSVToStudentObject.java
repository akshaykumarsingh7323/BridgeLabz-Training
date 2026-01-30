package com.csvdatahandling.convertcsvtoobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudentObject {

    public static void main(String[] args) {

        String filePath = "src/com/csvdatahandling/fileName.java";
        List<Student> students = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                if (data.length < 4) continue;

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file.");
            return;
        }
        
        if(students.isEmpty()) {
        	System.out.println("List is empty!");
        	return;
        }
        System.out.println("Student List:");
        System.out.println("-----------------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
