package com.dinkar.resumeanalyzer.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeAnalyzerService {

    public List<String> extractSkills(String text) {

        List<String> skills = new ArrayList<>();

        String lower = text.toLowerCase();

        if(lower.contains("java")) skills.add("Java");
        if(lower.contains("spring")) skills.add("Spring");
        if(lower.contains("sql")) skills.add("SQL");
        if(lower.contains("python")) skills.add("Python");
        if(lower.contains("c++")) skills.add("C++");

        return skills;
    }
}