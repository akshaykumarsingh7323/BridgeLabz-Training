package com.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFirstLine {
	
	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/com/javastream/FileCopy.java"))){
			
			String line = br.readLine();
			
			System.out.println(line);
					
		}catch(IOException e) {
			
			System.out.println("Error reading file!");
			
		}
	}
}
