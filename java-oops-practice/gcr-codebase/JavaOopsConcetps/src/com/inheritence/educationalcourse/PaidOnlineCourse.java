package com.inheritence.educationalcourse;

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;  

    PaidOnlineCourse(String courseName, int duration, String platform,
                     boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Fee         : ₹" + fee);
        System.out.println("Discount    : " + discount + "%");
        System.out.println("Final Fee   : ₹" + getFinalFee());
    }
}
