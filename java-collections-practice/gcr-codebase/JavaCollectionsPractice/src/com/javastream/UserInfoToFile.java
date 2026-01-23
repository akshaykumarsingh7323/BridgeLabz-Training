package com.javastream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInfoToFile {

    public static void main(String[] args) {

        BufferedReader br = null;
        FileWriter fw = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            fw = new FileWriter("userinfo.txt");

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("User information saved successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                System.out.println("Error while closing resources.");
            }
        }
    }
}
