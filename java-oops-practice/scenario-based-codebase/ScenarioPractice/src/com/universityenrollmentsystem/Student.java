package com.universityenrollmentsystem;

public class Student {

    private String name;
    private String studentId;
    private double gpa;   // private for data protection

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.gpa = 0.0;
    }

    public String getName() { return name; }
    public String getStudentId() { return studentId; }

    public double getGPA() { return gpa; }

    // Helper method to update GPA
    protected void updateGradePoint(double newPoints) {
        this.gpa = (this.gpa + newPoints) / 2;
    }

    public void displayInfo() {
        System.out.println("Student: " + name + " | ID: " + studentId + " | GPA: " + gpa);
    }
}
