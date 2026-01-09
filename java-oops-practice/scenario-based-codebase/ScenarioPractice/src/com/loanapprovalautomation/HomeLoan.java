package com.loanapprovalautomation;

public class HomeLoan extends LoanApplication {

    public HomeLoan(Applicant applicant, int term) {
        super(applicant, term, 8.5);   
    }

    @Override
    public boolean approveLoan() {
        boolean eligible = basicEligibility() && applicant.getCreditScore() >= 700;
        setApproved(eligible);
        return eligible;
    }

    @Override
    public double calculateEMI() {
        double P = applicant.getLoanAmount();
        double R = interestRate / (12 * 100);
        int N = term;

        return (P * R * Math.pow(1 + R, N)) /
               (Math.pow(1 + R, N) - 1);
    }
}
