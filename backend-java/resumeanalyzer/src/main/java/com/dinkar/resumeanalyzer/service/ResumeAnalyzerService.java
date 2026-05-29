package com.dinkar.resumeanalyzer.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeAnalyzerService {

    public List<String> extractSkills(String text) {

        List<String> skills = new ArrayList<>();

        String lower = text.toLowerCase();

        if (lower.contains("java"))
            skills.add("Java");

        if (lower.contains("spring"))
            skills.add("Spring");

        if (lower.contains("sql"))
            skills.add("SQL");

        if (lower.contains("python"))
            skills.add("Python");

        if (lower.contains("c++"))
            skills.add("C++");

        if (lower.contains("docker"))
            skills.add("Docker");

        if (lower.contains("aws"))
            skills.add("AWS");

        return skills;
    }

    public int calculateATSScore(List<String> skills) {

        int score = skills.size() * 15;

        return Math.min(score, 100);
    }

    public List<String> generateSuggestions(List<String> skills) {

        List<String> suggestions = new ArrayList<>();

        if (!skills.contains("Spring"))
            suggestions.add("Add Spring Boot projects");

        if (!skills.contains("Docker"))
            suggestions.add("Learn Docker and containerization");

        if (!skills.contains("AWS"))
            suggestions.add("Add cloud computing skills");

        if (!skills.contains("SQL"))
            suggestions.add("Improve database knowledge");

        suggestions.add("Include measurable achievements");
        suggestions.add("Add strong project descriptions");

        return suggestions;
    }
}