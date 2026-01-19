package com.generics.universitycoursemanagementsystem;

import java.util.List;

class UniversityUtil {

    public static void displayAllCourses(List<? extends CourseType> courseTypes) {
        for (CourseType ct : courseTypes) {
            System.out.println("Evaluation Type: " + ct.getEvaluationType());
            ct.evaluate();
        }
    }
}

