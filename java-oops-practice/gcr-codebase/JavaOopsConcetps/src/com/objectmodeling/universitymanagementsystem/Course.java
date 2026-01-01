package com.objectmodeling.universitymanagementsystem;

import java.util.*;

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void showCourseDetails() {
        System.out.println("\nCourse: " + courseName);

        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }

        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}
