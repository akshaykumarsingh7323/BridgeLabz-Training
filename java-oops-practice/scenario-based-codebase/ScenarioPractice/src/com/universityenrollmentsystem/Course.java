package com.universityenrollmentsystem;

public class Course {

    private String courseCode;
    private String title;
    private int credits;

    public Course(String courseCode, String title, int credits) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
    }

    public int getCredits() { return credits; }
    public String getTitle() { return title; }
}
