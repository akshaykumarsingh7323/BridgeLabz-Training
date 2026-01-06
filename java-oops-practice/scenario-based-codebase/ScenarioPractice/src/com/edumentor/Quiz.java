package com.edumentor;

import java.util.*;

public class Quiz {

    private List<String> questions;            
    private final List<String> correctAnswers;
    private int score;

    public Quiz(String difficulty) {
        questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();

        if (difficulty.equalsIgnoreCase("easy")) {
            questions.add("2 + 2 = ?");
            answers.add("4");
        } else if (difficulty.equalsIgnoreCase("medium")) {
            questions.add("5 * 6 = ?");
            answers.add("30");
        } else {
            questions.add("12 * 12 = ?");
            answers.add("144");
        }

        this.correctAnswers = Collections.unmodifiableList(answers);
    }

    public double evaluate(List<String> userAnswers) {
        score = 0;

        for (int i = 0; i < correctAnswers.size(); i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                score++; 
            }
        }

        return ((double) score / correctAnswers.size()) * 100;
    }

    public List<String> getQuestions() {
        return questions;
    }
}
