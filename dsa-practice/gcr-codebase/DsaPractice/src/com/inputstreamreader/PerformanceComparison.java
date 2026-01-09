package com.inputstreamreader;

import java.io.*;

public class PerformanceComparison {

    public static void main(String[] args) {

        int iterations = 1_000_000;
        String text = "hello";

        long startSB = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endSB = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endSB - startSB) + " ms");

        long startSBuf = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append(text);
        }
        long endSBuf = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (endSBuf - startSBuf) + " ms");

        String fileName = "largefile.txt";

        long startFR = System.currentTimeMillis();
        int wordCountFR = countWordsUsingFileReader(fileName);
        long endFR = System.currentTimeMillis();

        System.out.println("\nFileReader Word Count: " + wordCountFR);
        System.out.println("FileReader Time: " + (endFR - startFR) + " ms");

        long startISR = System.currentTimeMillis();
        int wordCountISR = countWordsUsingInputStreamReader(fileName);
        long endISR = System.currentTimeMillis();

        System.out.println("\nInputStreamReader Word Count: " + wordCountISR);
        System.out.println("InputStreamReader Time: " + (endISR - startISR) + " ms");
    }

    // FileReader method
    public static int countWordsUsingFileReader(String fileName) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("FileReader error");
        }
        return count;
    }

    public static int countWordsUsingInputStreamReader(String fileName) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {

            String line;
            while ((line = br.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("InputStreamReader error");
        }
        return count;
    }
}
