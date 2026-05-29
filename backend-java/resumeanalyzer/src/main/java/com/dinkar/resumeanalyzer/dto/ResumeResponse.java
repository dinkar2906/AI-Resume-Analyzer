package com.dinkar.resumeanalyzer.dto;

import java.util.List;

public class ResumeResponse {

    private List<String> skills;

    public ResumeResponse(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }
}