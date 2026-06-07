package com.dinkar.resumeanalyzer.controller;

import com.dinkar.resumeanalyzer.dto.ResumeResponse;
import com.dinkar.resumeanalyzer.entity.ResumeAnalysis;
import com.dinkar.resumeanalyzer.repository.ResumeAnalysisRepository;
import com.dinkar.resumeanalyzer.service.PdfService;
import com.dinkar.resumeanalyzer.service.ResumeAnalyzerService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/resume")
public class UploadController {

    private final PdfService pdfService;
    private final ResumeAnalyzerService analyzerService;
    private final ResumeAnalysisRepository repository;

    public UploadController(
            PdfService pdfService,
            ResumeAnalyzerService analyzerService,
            ResumeAnalysisRepository repository) {

        this.pdfService = pdfService;
        this.analyzerService = analyzerService;
        this.repository = repository;
    }

    @PostMapping("/upload")
    public ResumeResponse uploadResume(
            @RequestParam("file") MultipartFile file)
            throws Exception {

        String text =
                pdfService.extractText(
                        file.getInputStream());

        List<String> skills =
                analyzerService.extractSkills(text);

        int score =
                analyzerService.calculateATSScore(skills);

        List<String> suggestions =
                analyzerService.generateSuggestions(skills);

        ResumeAnalysis analysis =
                new ResumeAnalysis(
                        file.getOriginalFilename(),
                        score,
                        LocalDateTime.now()
                );

        repository.save(analysis);

        return new ResumeResponse(
                skills,
                score,
                suggestions
        );
    }
}