package com.universityenrollmentsystem;

public class UseUniversity {
    public static void main(String[] args) {

        Student s1 = new Undergraduate("Arjun", "UG101");
        Student s2 = new Postgraduate("Riya", "PG501");

        Course c1 = new Course("CS101", "Data Structures", 4);

        Faculty f1 = new Faculty("Dr. Mehta");

        Enrollment e1 = new Enrollment(s1, c1);

        s1.displayInfo();
        s2.displayInfo();

        f1.assignGrade(s1, c1, "A");
        e1.setGrade("A");
        e1.printEnrollmentDetails();

        System.out.println("Updated GPA of " + s1.getName() + " = " + s1.getGPA());
    }
}
