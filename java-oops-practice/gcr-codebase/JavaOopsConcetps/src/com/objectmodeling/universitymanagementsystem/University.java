package com.objectmodeling.universitymanagementsystem;

import java.util.*;

class University {
    private String universityName;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void addProfessor(Professor p) {
        professors.add(p);
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void showUniversityDetails() {
        System.out.println("\nUniversity: " + universityName);
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Professors: " + professors.size());
        System.out.println("Total Courses: " + courses.size());
    }
}
