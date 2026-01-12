package com.onlinelearningportal;

class Student extends User {
    private double progress;  
    private int grade;

    public Student(String name, String email) {
        super(name, email);
        this.progress = 0;
        this.grade = 0;
    }

    public void updateProgress(double value) {
        progress += value;
        if (progress > 100) progress = 100;
    }

    public void assignGrade(int marks) {
        grade = marks;
    }

    public int getGrade() {
        return grade;
    }

    public double getProgress() {
        return progress;
    }
}

