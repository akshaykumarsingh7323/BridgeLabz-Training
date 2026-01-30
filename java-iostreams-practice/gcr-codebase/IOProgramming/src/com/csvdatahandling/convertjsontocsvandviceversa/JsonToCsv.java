package com.csvdatahandling.convertjsontocsvandviceversa;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class JsonToCsv {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Student> students = Arrays.asList(mapper.readValue(new java.io.File("students.json"), Student[].class));

	        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"))) {
	
	            bw.write("ID,Name,Age,Marks");
	            bw.newLine();
	
	            for (Student s : students) {
	                bw.write(s.getId() + "," + s.getName() + "," +
	                         s.getAge() + "," + s.getMarks());
	                bw.newLine();
	            }
	        }catch(FileNotFoundException e) {
	        	System.out.println("File not found!");
	        }

	        System.out.println("JSON converted to CSV successfully!");
        }catch(FileNotFoundException e) {
        	System.out.println("File not found!");
        }
    }
}
