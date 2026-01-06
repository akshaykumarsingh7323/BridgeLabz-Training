package com.edumentor;

public class Learner extends User implements ICertifiable {

    private double percentage;
    private String courseType; 

    public Learner(String name, String email, int userId, String courseType) {
        super(name, email, userId);
        this.courseType = courseType;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public void generateCertificate() {
        if (courseType.equalsIgnoreCase("short")) {
            System.out.println("Short Course Certificate");
            System.out.println("Learner: " + name);
        } else {
            System.out.println("Full-Time Course Certificate");
            System.out.println("Learner: " + name);
            System.out.println("Score: " + percentage + "%");
        }
    }
}
