package com.onlinelearningportal;

public class UseLearningPortal {
    public static void main(String[] args) {

        Instructor inst = new Instructor("Rahul", "rahul@skillforge.com");

        String[] modules = {"OOP Basics", "Design Patterns", "Project"};
        Course course = new AdvancedCourse("Java Mastery", inst, modules);

        Student student = new Student("Akshay", "akshay@gmail.com");

        inst.uploadCourse(course);

        student.updateProgress(50);
        student.updateProgress(50);
        student.assignGrade(80);

        course.generateCertificate(student);
    }
}
