package com.encapsulation.bankingsystem;

interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}
