package com.onlineexamreviewsystem;

import java.util.*;

class ExamProctor {

    private Stack<Integer> navigationStack = new Stack<>();

    private HashMap<Integer, String> answerMap = new HashMap<>();

    private HashMap<Integer, String> correctAnswers = new HashMap<>();

    public ExamProctor() {
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");
    }

    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    public void submitAnswer(int questionId, String answer) {
        answerMap.put(questionId, answer);
        System.out.println("Answer saved for Q" + questionId);
    }

    public void goBack() {
        if (navigationStack.isEmpty()) {
            System.out.println("No previous question");
            return;
        }
        int last = navigationStack.pop();
        System.out.println("Returned from Question: " + last);
    }

    public void evaluate() {
        int score = 0;

        for (int qId : correctAnswers.keySet()) {
            if (answerMap.containsKey(qId) &&
                answerMap.get(qId).equals(correctAnswers.get(qId))) {
                score++;
            }
        }

        System.out.println("Exam Submitted");
        System.out.println("Final Score: " + score + "/" + correctAnswers.size());
    }
}
