package com.generics.universitycoursemanagementsystem;

class ResearchCourse extends CourseType {

    public ResearchCourse() {
        evaluationType = "Research-Based";
    }

    @Override
    void evaluate() {
        System.out.println("Evaluation through research work and thesis.");
    }
}

