package com.dinkar.resumeanalyzer.dto;

import java.util.List;

public class ResumeResponse {

    private List<String> skills;
    private int atsScore;
    private List<String> suggestions;

    public ResumeResponse(List<String> skills,
                          int atsScore,
                          List<String> suggestions) {
        this.skills = skills;
        this.atsScore = atsScore;
        this.suggestions = suggestions;
    }

    public List<String> getSkills() {
        return skills;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
}