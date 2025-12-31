package com.staticandfinal.level1;

public class UseStudent {

	public static void main(String[] args) {

		Student.setUniversityName("Global University");

	       Student student1 = new Student("Hemashree", 101, 'A');
	       Student student2 = new Student("Sharmila", 102, 'B');

	       Student.displayTotalStudents();

	       student1.displayStudentDetails();
	       System.out.println();
	       
	       student2.displayStudentDetails();
	       student2.updateGrade('A');
	       
	       System.out.println();

	       student2.displayStudentDetails();
	}
}
