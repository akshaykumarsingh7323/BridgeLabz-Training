package com.inheritence.educationalcourse;

public class UseCourse {
    public static void main(String[] args) {

        Course c1 = new Course("Java Basics", 40);
        Course c2 = new OnlineCourse("OOPs in Java", 30, "Udemy", true);
        Course c3 = new PaidOnlineCourse("Advanced Java", 50, "Coursera", true, 5000, 20);

        c1.displayDetails();
        System.out.println("-------------------");

        c2.displayDetails();
        System.out.println("-------------------");

        c3.displayDetails();
    }
}

