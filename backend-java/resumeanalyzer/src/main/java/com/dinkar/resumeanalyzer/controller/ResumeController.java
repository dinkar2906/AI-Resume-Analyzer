package com.dinkar.resumeanalyzer.controller;

import com.dinkar.resumeanalyzer.dto.ResumeRequest;
import com.dinkar.resumeanalyzer.dto.ResumeResponse;
import com.dinkar.resumeanalyzer.service.ResumeAnalyzerService;
import org.springframework.web.bind.annotation.*;

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

        return new ResumeResponse(
                service.extractSkills(
                        request.getResumeText()));
    }
}