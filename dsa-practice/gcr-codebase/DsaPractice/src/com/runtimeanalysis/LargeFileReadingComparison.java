package com.runtimeanalysis;

import java.io.*;
import java.util.Scanner;

public class LargeFileReadingComparison {

    public static void readUsingFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        long startTime = System.currentTimeMillis();

        int ch;
        while ((ch = fr.read()) != -1) {
        }

        long endTime = System.currentTimeMillis();
        fr.close();

        System.out.println("FileReader Time: " + (endTime - startTime) + " ms");
    }

    public static void readUsingInputStreamReader(String filePath) throws IOException {
        InputStreamReader isr =
                new InputStreamReader(new FileInputStream(filePath));

        long startTime = System.currentTimeMillis();

        int ch;
        while ((ch = isr.read()) != -1) {
        }

        long endTime = System.currentTimeMillis();
        isr.close();

        System.out.println("InputStreamReader Time: " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
        try {
        		System.out.println("Enter file path: ");
        		String filePath = sc.nextLine();
            readUsingFileReader(filePath);
            readUsingInputStreamReader(filePath);
        } catch (IOException e) {
        		System.out.println("File not found!");
         //   e.printStackTrace();
        }
    }
}
