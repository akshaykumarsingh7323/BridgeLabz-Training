package com.csvdatahandling.encryptanddecryptcsvdata;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEncryptedCSV {

    public static void main(String[] args) {

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter("employees_encrypted.csv"))) {

            bw.write("ID,Name,Email,Salary");
            bw.newLine();

            String emailEnc = AESUtil.encrypt("amit@gmail.com");
            String salaryEnc = AESUtil.encrypt("60000");

            bw.write("1,Amit," + emailEnc + "," + salaryEnc);
            bw.newLine();

            System.out.println("Encrypted CSV written successfully");

        } catch (IOException e) {
            System.out.println("Error writing CSV");
        }
    }
}

