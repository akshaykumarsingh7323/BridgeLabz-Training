package com.constructor.level1;

public class UseStudent {
	public static void main(String[] args) {
        Student s1 = new Student(101, "Akshay", 8.5);
        s1.display();

        s1.setCGPA(9.0);
        System.out.println("Updated CGPA: " + s1.getCGPA());

        PostgraduateStudent pg = new PostgraduateStudent(
            201, "Ravi", 8.8, "Computer Science"
        );
        pg.displayPGDetails();
    }
}
