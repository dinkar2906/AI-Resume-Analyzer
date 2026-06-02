package com.dinkar.resumeanalyzer.controller;

import com.dinkar.resumeanalyzer.dto.MatchRequest;
import com.dinkar.resumeanalyzer.dto.MatchResponse;
import com.dinkar.resumeanalyzer.service.ResumeAnalyzerService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
public class MatchController {

    private final ResumeAnalyzerService service;

    public MatchController(
            ResumeAnalyzerService service) {

        this.service = service;
    }

    @PostMapping("/match")
    public MatchResponse matchResume(
            @RequestBody MatchRequest request) {

        return service.matchResume(
                request.getResumeText(),
                request.getJobDescription()
        );
    }
}