package com.dinkar.resumeanalyzer.controller;

import com.dinkar.resumeanalyzer.entity.ResumeAnalysis;
import com.dinkar.resumeanalyzer.repository.ResumeAnalysisRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class ResumeHistoryController {

    private final ResumeAnalysisRepository repository;

    public ResumeHistoryController(
            ResumeAnalysisRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/history")
    public List<ResumeAnalysis> getHistory() {
        return repository.findAll();
    }
}