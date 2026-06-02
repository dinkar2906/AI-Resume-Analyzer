package com.dinkar.resumeanalyzer.dto;

import java.util.List;

public class MatchResponse {

    private int matchScore;
    private List<String> matchedSkills;
    private List<String> missingSkills;

    public MatchResponse(
            int matchScore,
            List<String> matchedSkills,
            List<String> missingSkills) {

        this.matchScore = matchScore;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
}