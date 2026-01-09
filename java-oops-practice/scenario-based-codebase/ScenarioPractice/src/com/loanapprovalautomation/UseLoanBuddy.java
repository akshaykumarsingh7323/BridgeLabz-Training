package com.loanapprovalautomation;

public class UseLoanBuddy {

    public static void main(String[] args) {

        Applicant applicant = new Applicant(
                "Akshay",
                720,
                80000,
                500000
        );

        LoanApplication loan = new HomeLoan(applicant, 240);

        if (loan.approveLoan()) {
            System.out.println("Loan Approved!");
            System.out.println("Monthly EMI: Rs " + loan.calculateEMI());
        } else {
            System.out.println("Loan Rejected!");
        }
    }
}

