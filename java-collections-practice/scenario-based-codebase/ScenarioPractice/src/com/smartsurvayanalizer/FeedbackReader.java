package com.smartsurvayanalizer;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FeedbackReader {

    private static final Pattern RATING_PATTERN =
            Pattern.compile("(\\d{1,2})/10");

    public static void readFeedbackFiles(File folder,
            Map<String, List<String>> feedbackMap) {

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Feedback folder not found!");
            return;
        }

        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                readFile(file, feedbackMap);
            }
        }
    }

    private static void readFile(File file,
            Map<String, List<String>> feedbackMap) {

        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                processLine(line, feedbackMap);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }

    private static void processLine(String line,
            Map<String, List<String>> feedbackMap) {

        try {
            Matcher matcher = RATING_PATTERN.matcher(line);

            if (!matcher.find()) {
                throw new IllegalArgumentException("Rating missing");
            }

            int rating = Integer.parseInt(matcher.group(1));

            Feedback<String> feedback =
                    new Feedback<>("Service", line, rating);

            if (rating >= 7) {
                feedbackMap.get(FeedbackCategory.POSITIVE)
                           .add(feedback.toString());
            } else if (rating >= 5) {
                feedbackMap.get(FeedbackCategory.NEUTRAL)
                           .add(feedback.toString());
            } else {
                feedbackMap.get(FeedbackCategory.NEGATIVE)
                           .add(feedback.toString());
            }

        } catch (Exception e) {
            System.out.println("Skipping invalid feedback: " + line);
        }
    }
}

