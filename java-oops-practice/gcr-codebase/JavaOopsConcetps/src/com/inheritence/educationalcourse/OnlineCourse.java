package com.inheritence.educationalcourse;

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Platform    : " + platform);
        System.out.println("Recorded    : " + (isRecorded ? "Yes" : "No"));
    }
}
