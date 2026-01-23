package com.interfaces.map;

import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                line = line.toLowerCase();

                line = line.replaceAll("[^a-z ]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println(map);

        }
        catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing file");
            }
        }
    }
}
