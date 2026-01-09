package com.loanapprovalautomation;

public abstract class LoanApplication implements IApprovable {

    protected Applicant applicant;
    protected int term;               
    protected double interestRate;    
    private boolean approved;      

    public LoanApplication(Applicant applicant, int term, double interestRate) {
        this.applicant = applicant;
        this.term = term;
        this.interestRate = interestRate;
    }

    protected boolean basicEligibility() {
        return applicant.getCreditScore() >= 650 &&
               applicant.getIncome() >= applicant.getLoanAmount() / 10;
    }

    protected void setApproved(boolean status) {
        this.approved = status;   // internal use only
    }

    public boolean isApproved() {
        return approved;
    }
}
