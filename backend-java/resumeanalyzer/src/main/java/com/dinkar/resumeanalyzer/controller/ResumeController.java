package com.dinkar.resumeanalyzer.controller;

import com.dinkar.resumeanalyzer.dto.ResumeRequest;
import com.dinkar.resumeanalyzer.dto.ResumeResponse;
import com.dinkar.resumeanalyzer.service.ResumeAnalyzerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeAnalyzerService service;

    public ResumeController(ResumeAnalyzerService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public ResumeResponse analyze(
            @RequestBody ResumeRequest request) {

        List<String> skills =
                service.extractSkills(
                        request.getResumeText());

        int score =
                service.calculateATSScore(skills);

        List<String> suggestions =
                service.generateSuggestions(skills);

        return new ResumeResponse(
                skills,
                score,
                suggestions
        );
    }
}