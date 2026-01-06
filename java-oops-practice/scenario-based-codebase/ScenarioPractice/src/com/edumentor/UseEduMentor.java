package com.edumentor;

import java.util.*;

public class UseEduMentor {

    public static void main(String[] args) {

        Instructor instructor = new Instructor("Dr. Smith", "smith@edu.com", 101);

        Learner learner = new Learner("Akshay", "akshay@edu.com", 201, "full-time");

        Quiz quiz = new Quiz("medium");

        List<String> learnerAnswers = new ArrayList<>();
        learnerAnswers.add("30");

        double percentage = quiz.evaluate(learnerAnswers);
        learner.setPercentage(percentage);

        System.out.println("Quiz Score: " + percentage + "%");

        learner.generateCertificate();
    }
}
