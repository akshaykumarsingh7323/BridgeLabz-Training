package com.objectmodeling.universitymanagementsystem;

public class UseUniversity {
    public static void main(String[] args) {

        University uni = new University("Global Tech University");

        Student s1 = new Student(1, "Akshay");
        Student s2 = new Student(2, "Rohan");

        Professor p1 = new Professor(101, "Dr. Sharma");
        Professor p2 = new Professor(102, "Dr. Mehta");

        Course c1 = new Course("Java Programming");
        Course c2 = new Course("Data Structures");

        uni.addStudent(s1);
        uni.addStudent(s2);
        uni.addProfessor(p1);
        uni.addProfessor(p2);
        uni.addCourse(c1);
        uni.addCourse(c2);

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s1.enrollCourse(c2);
        System.out.println();

        p1.assignCourse(c1);
        p2.assignCourse(c2);
        System.out.println();

        s1.showCourses();
        p1.showCourses();
        System.out.println();

        c1.showCourseDetails();
        c2.showCourseDetails();

        uni.showUniversityDetails();
    }
}
