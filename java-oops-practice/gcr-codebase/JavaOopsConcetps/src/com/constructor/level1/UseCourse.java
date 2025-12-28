package com.constructor.level1;

public class UseCourse {
	public static void main(String[] args) {
        Course c1 = new Course("Java Full Stack", 6, 45000);
        Course c2 = new Course("Python Data Science", 8, 60000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("XYZ Technologies");

        System.out.println("\nAfter updating institute name:\n");

        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
