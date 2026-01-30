package com.csvdatahandling.convertjsontocsvandviceversa;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvToJson {

    public static void main(String[] args) throws Exception {

        List<Student> students = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {

            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3])
                ));
            }

	        ObjectMapper mapper = new ObjectMapper();
	        mapper.writerWithDefaultPrettyPrinter()
	              .writeValue(new java.io.File("students_converted.json"), students);
	
	        System.out.println("CSV converted to JSON successfully!");
        }catch(FileNotFoundException e) {
        	System.out.println("File not found!");
        }
    }
}
