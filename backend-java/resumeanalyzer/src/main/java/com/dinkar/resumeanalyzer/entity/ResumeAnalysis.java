package com.dinkar.resumeanalyzer.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ResumeAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private Integer atsScore;

    private LocalDateTime uploadDate;

    public ResumeAnalysis() {
    }

    public ResumeAnalysis(String fileName,
                          Integer atsScore,
                          LocalDateTime uploadDate) {
        this.fileName = fileName;
        this.atsScore = atsScore;
        this.uploadDate = uploadDate;
    }

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public Integer getAtsScore() {
        return atsScore;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }
}