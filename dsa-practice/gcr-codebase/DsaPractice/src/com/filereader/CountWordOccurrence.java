package com.filereader;

import java.io.*;

public class CountWordOccurrence {
    public static void main(String[] args) {
        String targetWord = "Java";
        int count = 0;

        try {
            FileReader fileReader = new FileReader("input.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

            bufferedReader.close();
            fileReader.close();

            System.out.println("Word '" + targetWord + "' occurs " + count + " times.");

        } catch (IOException e) {
            System.out.println("File reading error!");
        }
    }
}

