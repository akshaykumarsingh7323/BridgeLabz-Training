package com.objectmodeling.studentmanagement;

import java.util.*;

class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    // Association method
    public void addStudent(Student student) {
        students.add(student);
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

