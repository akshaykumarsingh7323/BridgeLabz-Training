package com.objectmodeling.universitymanagementsystem;

import java.util.*;

class Professor {
    private int profId;
    private String name;
    private List<Course> courses;

    public Professor(int profId, String name) {
        this.profId = profId;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course course) {
        courses.add(course);
        course.assignProfessor(this);
        System.out.println("Prof. " + name + " assigned to " + course.getCourseName());
    }

    public void showCourses() {
        System.out.println("Professor " + name + " teaches:");
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}
