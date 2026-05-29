package com.dinkar.resumeanalyzer.controller;

import com.dinkar.resumeanalyzer.dto.ResumeResponse;
import com.dinkar.resumeanalyzer.service.PdfService;
import com.dinkar.resumeanalyzer.service.ResumeAnalyzerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class UploadController {

    private final PdfService pdfService;
    private final ResumeAnalyzerService analyzerService;

    public UploadController(
            PdfService pdfService,
            ResumeAnalyzerService analyzerService) {

        this.pdfService = pdfService;
        this.analyzerService = analyzerService;
    }

    @PostMapping("/upload")
    public ResumeResponse uploadResume(
            @RequestParam("file")
            MultipartFile file) throws Exception {

        String text =
                pdfService.extractText(
                        file.getInputStream());

        List<String> skills =
                analyzerService.extractSkills(text);

        int score =
                analyzerService.calculateATSScore(skills);

        List<String> suggestions =
                analyzerService.generateSuggestions(skills);

        return new ResumeResponse(
                skills,
                score,
                suggestions
        );
    }
}