package com.smartsurvayanalizer;

import java.io.File;
import java.util.*;

public class UseFeedback {

    public static void main(String[] args) {

        Map<String, List<String>> feedbackMap = new HashMap<>();
        feedbackMap.put(FeedbackCategory.POSITIVE, new ArrayList<>());
        feedbackMap.put(FeedbackCategory.NEUTRAL, new ArrayList<>());
        feedbackMap.put(FeedbackCategory.NEGATIVE, new ArrayList<>());

        File folder = new File("feedbacks");

        FeedbackReader.readFeedbackFiles(folder, feedbackMap);

        feedbackMap.forEach((k, v) -> {
            System.out.println("\n" + k + " Feedback:");
            v.forEach(System.out::println);
        });
    }
}

