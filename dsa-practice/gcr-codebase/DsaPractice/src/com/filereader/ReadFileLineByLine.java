package com.filereader;

import java.io.*;
import java.util.Scanner;

public class ReadFileLineByLine {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter path: ");
    	String input = sc.nextLine();
    	
        try {
            FileReader fileReader = new FileReader(input);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("File reading error!");
        }
    }
}
