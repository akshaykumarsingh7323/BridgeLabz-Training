package com.csvdatahandling.encryptanddecryptcsvdata;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDecryptedCSV {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("employees_encrypted.csv"))) {

            br.readLine(); 
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String email = AESUtil.decrypt(data[2]);
                String salary = AESUtil.decrypt(data[3]);

                System.out.println("ID     : " + data[0]);
                System.out.println("Name   : " + data[1]);
                System.out.println("Email  : " + email);
                System.out.println("Salary : " + salary);
                System.out.println("----------------------");
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV");
        }
    }
}
