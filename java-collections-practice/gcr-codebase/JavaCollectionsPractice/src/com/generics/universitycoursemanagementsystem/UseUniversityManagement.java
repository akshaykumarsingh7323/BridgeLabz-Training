package com.generics.universitycoursemanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class UseUniversityManagement {
    public static void main(String[] args) {

        Course<ExamCourse> math =
            new Course<>("Mathematics", new ExamCourse());

        Course<AssignmentCourse> software =
            new Course<>("Software Engineering", new AssignmentCourse());

        Course<ResearchCourse> ai =
            new Course<>("Artificial Intelligence Research", new ResearchCourse());

        math.displayCourse();
        software.displayCourse();
        ai.displayCourse();

        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        System.out.println("\nDisplaying using Wildcards:");
        UniversityUtil.displayAllCourses(courseTypes);
    }
}
