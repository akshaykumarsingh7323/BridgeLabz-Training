package com.onlineexamreviewsystem;

public class UseExamProtector {
    public static void main(String[] args) {

        ExamProctor exam = new ExamProctor();

        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");

        exam.visitQuestion(2);
        exam.submitAnswer(2, "B");

        exam.visitQuestion(3);
        exam.submitAnswer(3, "A"); 

        exam.goBack();

        exam.visitQuestion(4);
        exam.submitAnswer(4, "D");

        exam.evaluate();
    }
}
