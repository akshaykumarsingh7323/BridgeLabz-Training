package com.inheritence.schoolsystem;

public class SchoolSystem {
    public static void main(String[] args) {

    	Person teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Person student = new Student("Ria", 15, "10th Grade");
        Person staff = new Staff("Mrs. Mehta", 35, "Administration");


        Person[] people = {teacher, student, staff};


        for (Person p : people) {
            p.displayDetails();
            p.displayRole();
            System.out.println("---------------------------");
        }
    }
}
