package com.constructor.level1;

public class Course {
	String courseName;
	int duration;
	double fee;
	
	static String instituteName = "ABC Institute";
	
	Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
	
	void displayCourseDetails() {
        System.out.println(
            "Institute: " + instituteName +
            ", Course Name: " + courseName +
            ", Duration: " + duration + " months" +
            ", Fee: ₹" + fee
        );
	}   
	
	   static void updateInstituteName(String newInstituteName) {
	        instituteName = newInstituteName;
	    }
}
