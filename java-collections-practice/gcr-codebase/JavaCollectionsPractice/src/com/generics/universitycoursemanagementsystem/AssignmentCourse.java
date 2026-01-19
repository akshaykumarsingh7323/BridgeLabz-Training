package com.generics.universitycoursemanagementsystem;

class AssignmentCourse extends CourseType {

    public AssignmentCourse() {
        evaluationType = "Assignment-Based";
    }

    @Override
    void evaluate() {
        System.out.println("Evaluation through assignments.");
    }
}
