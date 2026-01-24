package com.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/com/javastream/FileCopy.java");
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			System.out.println("---------- File Content -----------\n");
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		}catch(IOException e) {
			System.out.println("File not found");
			
		}
	}
}
