package com.objectmodeling.universitymanagementsystem;

import java.util.*;

class Student {
    private int studentId;
    private String name;
    private List<Course> courses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public void showCourses() {
        System.out.println("Student: " + name + " enrolled in:");
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}

