package com.collegeinformationsystem;

public class UseCollegeInformationsystem {

    public static void main(String[] args) {

        Faculty faculty = new Faculty(101, "Dr. Sharma", "sharma@college.edu", "Computer Science");

        Course javaCourse = new Course(501, "Java Programming", faculty);

        Student s1 = new Student(1, "Akshay", "akshay@student.edu");
        Student s2 = new Student(2, "Ravi", "ravi@student.edu");

        s1.addGrade(8.5);
        s1.addGrade(9.0);

        s2.addGrade(7.5);
        s2.addGrade(8.0);

        s1.enrollCourse(javaCourse);
        s2.enrollCourse(javaCourse);

        System.out.println("\n--- Student Details ---");
        s1.printDetails();
        System.out.println();
        s2.printDetails();

        System.out.println("\n--- Faculty Details ---");
        faculty.printDetails();

        javaCourse.printCourseDetails();
    }
}
