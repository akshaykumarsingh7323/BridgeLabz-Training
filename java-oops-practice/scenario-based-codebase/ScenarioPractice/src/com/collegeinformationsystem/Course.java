package com.collegeinformationsystem;

import java.util.*;

class Course {
    private int courseId;
    private String courseName;
    private Faculty faculty;
    private List<Student> students;

    public Course(int courseId, String courseName, Faculty faculty) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.faculty = faculty;
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void printCourseDetails() {
        System.out.println("\nCourse ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Faculty: " + faculty.name);
        System.out.println("Enrolled Students: " + students.size());
    }
}
