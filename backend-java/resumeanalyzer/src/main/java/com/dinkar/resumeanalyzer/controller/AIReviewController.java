package com.dinkar.resumeanalyzer.controller;

import com.dinkar.resumeanalyzer.dto.AIReviewResponse;
import com.dinkar.resumeanalyzer.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
public class AIReviewController {

    private final GeminiService geminiService;

    public AIReviewController(
            GeminiService geminiService) {

        this.geminiService = geminiService;
    }

    @PostMapping("/ai-feedback")
    public AIReviewResponse review(
            @RequestBody String resumeText)
            throws Exception {

        String result =
                geminiService.analyzeResume(
                        resumeText);

        return new AIReviewResponse(result);
    }
}