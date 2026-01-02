package com.universityenrollmentsystem;

public class Faculty implements Graded {

    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    @Override
    public void assignGrade(Student student, Course course, String grade) {
        System.out.println("Faculty " + name + " assigned grade " + grade +
                " for course " + course.getTitle());

        double points = calculateGradePoints(grade);
        student.updateGradePoint(points);
    }

    // Helper Method
    private double calculateGradePoints(String grade) {
        switch (grade) {
            case "A": return 9.0;
            case "B": return 8.0;
            case "C": return 7.0;
            default: return 5.0;
        }
    }
}
