package com.generics.universitycoursemanagementsystem;

class ExamCourse extends CourseType {

    public ExamCourse() {
        evaluationType = "Exam-Based";
    }

    @Override
    void evaluate() {
        System.out.println("Evaluation through written exams.");
    }
}
