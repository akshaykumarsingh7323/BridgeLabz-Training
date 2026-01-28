package com.resumeanalyzer;

public class ResumeData {

    String email;
    String phone;
    int keywordCount;

    public ResumeData(String email, String phone, int keywordCount) {
        this.email = email;
        this.phone = phone;
        this.keywordCount = keywordCount;
    }

    @Override
    public String toString() {
        return "Email: " + email +
               ", Phone: " + phone +
               ", Keyword Matches: " + keywordCount;
    }
}

