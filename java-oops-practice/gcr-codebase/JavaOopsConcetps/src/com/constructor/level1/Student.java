package com.constructor.level1;

class Student {

    public int rollNumber;
    protected String name;
    private double CGPA;

    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0 && CGPA <= 10) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value!");
        }
    }

    void display() {
        System.out.println( "Roll No: " + rollNumber + ", Name: " + name + ", CGPA: " + CGPA);
    }
}


class PostgraduateStudent extends Student {

    String specialization;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    void displayPGDetails() {
        System.out.println(
            "Roll No: " + rollNumber +       
            ", Name: " + name +            
            ", Specialization: " + specialization +
            ", CGPA: " + getCGPA()          
        );
    }
}
