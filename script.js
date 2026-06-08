const API_BASE = "https://resume-analyzer-api-e2b5.onrender.com";
// For local testing, use:
// const API_BASE = "http://localhost:8080";

const resumeFile = document.getElementById("resumeFile");
const uploadZone = document.getElementById("uploadZone");
const fileName = document.getElementById("fileName");
const analyzeBtn = document.getElementById("analyzeBtn");
const loading = document.getElementById("loading");
const statusEl = document.getElementById("status");
const resultCard = document.getElementById("resultCard");

const scoreRing = document.getElementById("scoreRing");
const scoreValue = document.getElementById("scoreValue");
const skillsList = document.getElementById("skillsList");
const suggestionsList = document.getElementById("suggestionsList");

function escapeHtml(text) {
    return String(text)
        .replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;")
        .replaceAll('"', "&quot;")
        .replaceAll("'", "&#039;");
}

function setLoading(isLoading) {
    loading.hidden = !isLoading;
    analyzeBtn.disabled = isLoading || !resumeFile.files[0];
    resumeFile.disabled = isLoading;
}

function setStatus(message, isError = false) {
    statusEl.textContent = message;
    statusEl.style.color = isError ? "#b91c1c" : "#6b7280";
}

function updateUploadState() {
    const file = resumeFile.files[0];

    if (file) {
        fileName.textContent = file.name;
        uploadZone.classList.add("has-file");
        analyzeBtn.disabled = false;
        setStatus("Ready to analyze your resume.");
    } else {
        fileName.textContent = "No file selected";
        uploadZone.classList.remove("has-file");
        analyzeBtn.disabled = true;
        setStatus("Choose a PDF to begin.");
    }
}

function scoreLabel(score) {
    if (score >= 80) return "Strong match";
    if (score >= 60) return "Good match";
    if (score >= 40) return "Needs improvement";
    return "Low match";
}

function renderSkills(skills) {
    skillsList.innerHTML = "";

    if (!skills || skills.length === 0) {
        skillsList.innerHTML = "<span class='muted'>No skills detected.</span>";
        return;
    }

    skillsList.innerHTML = skills
        .map(skill => `<span class="tag">${escapeHtml(skill)}</span>`)
        .join("");
}

function renderSuggestions(suggestions) {
    suggestionsList.innerHTML = "";

    if (!suggestions || suggestions.length === 0) {
        suggestionsList.innerHTML = "<li>No suggestions available.</li>";
        return;
    }

    suggestionsList.innerHTML = suggestions
        .map(item => `<li>${escapeHtml(item)}</li>`)
        .join("");
}

function renderScore(score) {
    const safeScore = Math.max(0, Math.min(100, Number(score) || 0));
    scoreValue.textContent = safeScore.toString();

    const color =
        safeScore >= 80 ? "#166534" :
        safeScore >= 60 ? "#b45309" :
        "#991b1b";

    scoreRing.style.background = `conic-gradient(${color} 0 ${safeScore}%, #e5e7eb ${safeScore}% 100%)`;

    scoreValue.style.color = color;
}

async function analyzeResume() {
    const file = resumeFile.files[0];

    if (!file) {
        setStatus("Please choose a PDF resume first.", true);
        return;
    }

    if (!file.name.toLowerCase().endsWith(".pdf")) {
        setStatus("Please upload a PDF file only.", true);
        return;
    }

    setLoading(true);
    setStatus("Uploading and analyzing your resume...");

    const formData = new FormData();
    formData.append("file", file);

    try {
        const response = await fetch(`${API_BASE}/api/resume/upload`, {
            method: "POST",
            body: formData
        });

        if (!response.ok) {
            const text = await response.text();
            throw new Error(text || "Request failed");
        }

        const data = await response.json();

        renderScore(data.atsScore);
        renderSkills(data.skills);
        renderSuggestions(data.suggestions);

        resultCard.hidden = false;
        setStatus(`Analysis complete. ${scoreLabel(data.atsScore)}.`);
    } catch (error) {
        console.error(error);
        setStatus("Unable to analyze the resume right now. Please try again.", true);
    } finally {
        setLoading(false);
    }
}

resumeFile.addEventListener("change", updateUploadState);

uploadZone.addEventListener("click", () => {
    resumeFile.click();
});

uploadZone.addEventListener("keydown", (event) => {
    if (event.key === "Enter" || event.key === " ") {
        event.preventDefault();
        resumeFile.click();
    }
});

analyzeBtn.addEventListener("click", analyzeResume);

updateUploadState();
