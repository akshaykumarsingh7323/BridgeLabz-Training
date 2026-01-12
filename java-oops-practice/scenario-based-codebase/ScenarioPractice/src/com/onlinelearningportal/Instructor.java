package com.onlinelearningportal;

class Instructor extends User {

    public Instructor(String name, String email) {
        super(name, email);
    }

    public void uploadCourse(Course course) {
        System.out.println(name + " uploaded course: " + course.getTitle());
    }
}
