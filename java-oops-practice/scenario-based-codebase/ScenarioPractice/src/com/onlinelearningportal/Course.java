package com.onlinelearningportal;

class Course implements ICertifiable {

    private String title;
    private Instructor instructor;
    private String[] modules;

    protected double rating;

    private final String[] reviews;

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
        this.modules = new String[] {"Introduction", "Basics", "Advanced"};
        this.reviews = new String[] {"Good content", "Well structured"};
    }

    public Course(String title, Instructor instructor, String[] modules) {
        this.title = title;
        this.instructor = instructor;
        this.modules = modules;
        this.reviews = new String[] {"Excellent"};
    }

    protected void updateRating(double newRating) {
        rating = (rating + newRating) / 2;
    }

    public String[] getReviews() {
        return reviews.clone(); 
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void generateCertificate(Student student) {
        if (student.getProgress() >= 100 && student.getGrade() >= 60) {
            System.out.println("Certificate of Completion");
            System.out.println("Awarded to: " + student.name);
            System.out.println("Course: " + title);
        } else {
            System.out.println("Course not completed yet.");
        }
    }
}
