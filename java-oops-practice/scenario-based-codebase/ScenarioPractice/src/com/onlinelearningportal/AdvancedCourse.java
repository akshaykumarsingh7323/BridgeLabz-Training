package com.onlinelearningportal;

class AdvancedCourse extends Course {

    public AdvancedCourse(String title, Instructor instructor, String[] modules) {
        super(title, instructor, modules);
    }

    @Override
    public void generateCertificate(Student student) {
        if (student.getProgress() >= 100 && student.getGrade() >= 75) {
            System.out.println("Advanced Skill Certificate");
            System.out.println("Awarded to: " + student.name);
            System.out.println("Course: " + getTitle());
            System.out.println("Level: Advanced");
        } else {
            System.out.println("Advanced requirements not met.");
        }
    }
}

