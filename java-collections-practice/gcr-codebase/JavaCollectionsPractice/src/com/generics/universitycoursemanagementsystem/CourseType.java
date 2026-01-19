package com.generics.universitycoursemanagementsystem;

abstract class CourseType {
    protected String evaluationType;

    public String getEvaluationType() {
        return evaluationType;
    }

    abstract void evaluate();
}

