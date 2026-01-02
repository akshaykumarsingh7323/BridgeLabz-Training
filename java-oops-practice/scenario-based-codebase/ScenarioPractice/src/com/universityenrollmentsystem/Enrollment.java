package com.universityenrollmentsystem;

public class Enrollment {

    private Student student;
    private Course course;
    private String grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void printEnrollmentDetails() {
        System.out.println("Enrollment -> " + student.getName() +
                " enrolled in " + course.getTitle() +
                " | Grade: " + grade);
    }
}
