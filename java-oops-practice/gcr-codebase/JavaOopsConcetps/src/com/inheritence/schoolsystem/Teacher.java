package com.inheritence.schoolsystem;

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age); // call Person constructor
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

