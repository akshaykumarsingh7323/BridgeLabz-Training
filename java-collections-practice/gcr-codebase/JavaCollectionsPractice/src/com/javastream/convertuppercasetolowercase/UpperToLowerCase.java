package com.javastream.convertuppercasetolowercase;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UpperToLowerCase {

    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(inputFile),
                            StandardCharsets.UTF_8));

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(outputFile),
                            StandardCharsets.UTF_8))
        ) {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File converted to lowercase successfully.");

        } catch (IOException e) {
            System.out.println("I/O error occurred: " + e.getMessage());
        }
    }
}

