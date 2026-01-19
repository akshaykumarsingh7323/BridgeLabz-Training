package com.generics.universitycoursemanagementsystem;

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void displayCourse() {
        System.out.println("Course: " + courseName);
        System.out.println("Evaluation Type: " + courseType.getEvaluationType());
        courseType.evaluate();
        System.out.println("-------------------------");
    }

    public T getCourseType() {
        return courseType;
    }
}
