package com.javastream.wordcount;

import java.io.*;
import java.util.*;

public class WordCountTopFive {

    public static void main(String[] args) {

        String filePath = "input.txt";

        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word,
                                wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        List<Map.Entry<String, Integer>> wordList =
                new ArrayList<>(wordCountMap.entrySet());

        wordList.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 5 most frequent words:");

        for (int i = 0; i < Math.min(5, wordList.size()); i++) {
            Map.Entry<String, Integer> entry = wordList.get(i);
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

