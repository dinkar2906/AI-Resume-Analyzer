package com.dinkar.resumeanalyzer.dto;

public class AIReviewResponse {

    private String feedback;

    public AIReviewResponse(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }
}