package com.csvdatahandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\d{10}$");

    public static void main(String[] args) {

        String filePath = "src/com/csvdatahandling/CountCSVRows.java";
        String line;
        int rowNumber = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while ((line = br.readLine()) != null) {
                rowNumber++;

                String[] data = line.split(",");

                if (data.length < 4) {
                    System.out.println("Row " + rowNumber + " Invalid format");
                    continue;
                }

                String email = data[2].trim();
                String phone = data[3].trim();

                boolean validEmail = EMAIL_PATTERN.matcher(email).matches();
                boolean validPhone = PHONE_PATTERN.matcher(phone).matches();

                if (!validEmail || !validPhone) {
                    System.out.println("Invalid Row at line " + rowNumber + ":");
                    System.out.println("Data → " + line);

                    if (!validEmail) {
                        System.out.println("Invalid Email format");
                    }
                    if (!validPhone) {
                        System.out.println("Phone number must be exactly 10 digits");
                    }
                    System.out.println("----------------------------------");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file.");
        }
    }
}
