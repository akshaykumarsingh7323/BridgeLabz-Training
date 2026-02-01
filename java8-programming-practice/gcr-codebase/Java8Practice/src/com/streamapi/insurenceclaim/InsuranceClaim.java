package com.streamapi.insurenceclaim;

public class InsuranceClaim {

    private String claimId;
    private String claimType;   
    private double amount;

    public InsuranceClaim(String claimId, String claimType, double amount) {
        this.claimId = claimId;
        this.claimType = claimType;
        this.amount = amount;
    }

    public String getClaimId() {
        return claimId;
    }

    public String getClaimType() {
        return claimType;
    }

    public double getAmount() {
        return amount;
    }
}

