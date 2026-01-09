package com.filereader;

import java.io.*;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("input.txt");

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
