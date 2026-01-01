package com.objectmodeling.universitymanagement;

public class UseUniversity {
    public static void main(String[] args) {

        Faculty f1 = new Faculty(101, "Dr. Sharma");
        Faculty f2 = new Faculty(102, "Dr. Mehta");

        University uni = new University("National University");

        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical");

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.showDetails();

        System.out.println("\n--- Deleting University ---");
        uni.destroyUniversity();

        System.out.println("\nFaculty still exists independently:");
        f1.display();
        f2.display();
    }
}

