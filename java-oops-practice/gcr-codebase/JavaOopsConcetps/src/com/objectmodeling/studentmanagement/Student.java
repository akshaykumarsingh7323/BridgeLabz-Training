package com.objectmodeling.studentmanagement;

import java.util.*;

class Student {
    private int rollNo;
    private String name;
    private List<Course> courses;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Many-to-Many Association
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void viewCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}

