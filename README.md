# AI Resume Analyzer API

## Overview

AI Resume Analyzer is a full stack application that helps users analyze resumes using Artificial Intelligence. The platform extracts skills from PDF resumes, calculates ATS scores, generates improvement suggestions, stores resume analysis history, matches resumes against job descriptions, and provides AI powered feedback using Google Gemini AI.

## Features

* Resume PDF Upload
* Skill Extraction
* ATS Score Calculation
* Resume Improvement Suggestions
* Resume History Tracking
* Job Description Matching
* AI Powered Resume Feedback
* PostgreSQL Database Storage
* Swagger API Documentation
* Docker Support
* Render Deployment

## Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Apache PDFBox
* Swagger OpenAPI
* Docker

### Frontend

* HTML
* CSS
* JavaScript

### AI Integration

* Google Gemini AI

## API Endpoints

### Resume Upload

POST /api/resume/upload

Upload a PDF resume and receive extracted skills, ATS score, and improvement suggestions.

### Resume Analysis

POST /api/resume/analyze

Analyze resume content and generate recommendations.

### Resume History

GET /api/resume/history

Retrieve previously analyzed resumes.

### Job Description Matching

POST /api/resume/match

Compare a resume against a job description and calculate a matching score.

### AI Resume Review

POST /api/resume/ai-review

Generate AI powered resume feedback using Google Gemini AI.

### Health Check

GET /api/health

Check application status.

## Project Structure

AI Resume Analyzer API

backend-java

resumeanalyzer

frontend

screenshots

docs

README.md

## Local Setup

### Clone Repository

git clone https://github.com/dinkar2906/AI-Resume-Analyzer-API.git

cd AI-Resume-Analyzer-API

### Backend Setup

cd backend-java/resumeanalyzer

Configure application properties and environment variables.

Run application:

./mvnw spring-boot

### Frontend Setup

cd frontend

python3 -m http.server 5500

Open:

http://localhost:5500

## Docker Setup

Build Docker image:

docker build -t resume-analyzer .

Run container:

docker run -p 8080:8080 resume-analyzer

## Deployment

Backend deployed on Render

Frontend deployed using GitHub Pages

Database hosted on Render PostgreSQL

## Screenshots
<img width="927" height="662" alt="image" src="https://github.com/user-attachments/assets/a99bcd64-ffd6-4df8-ba80-bacba80507c6" />



## Future Improvements

* Advanced ATS Scoring
* Authentication and User Accounts
* Resume Comparison
* Multiple Resume Formats
* AI Generated Cover Letters

## Author

Dinkar Upadhyay
