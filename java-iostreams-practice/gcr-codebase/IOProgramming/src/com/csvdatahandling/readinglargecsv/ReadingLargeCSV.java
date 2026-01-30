package com.csvdatahandling.readinglargecsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingLargeCSV {

    private static final int BATCH_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "large.csv";   
        String line;
        long totalCount = 0;

        List<String> batch = new ArrayList<>(BATCH_SIZE);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            while ((line = br.readLine()) != null) {

                batch.add(line);

                if (batch.size() == BATCH_SIZE) {
                    processBatch(batch);
                    totalCount += batch.size();
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                processBatch(batch);
                totalCount += batch.size();
            }

            System.out.println("\nTotal records processed: " + totalCount);

        } catch (IOException e) {
            System.out.println("Error reading large CSV file");
        }
    }

    private static void processBatch(List<String> batch) {
        System.out.println("Processed batch of " + batch.size() + " records");
    }
}

