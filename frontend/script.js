const API =
"https://resume-analyzer-api-e2b5.onrender.com";

async function analyzeResume() {

    const file =
        document.getElementById("resumeFile")
        .files[0];

    if (!file) {

        alert("Please select a PDF resume.");

        return;
    }

    document.getElementById("loading")
        .innerText =
        "Analyzing resume...";

    const formData =
        new FormData();

    formData.append("file", file);

    try {

        const response =
            await fetch(
                API + "/api/resume/upload",
                {
                    method: "POST",
                    body: formData
                }
            );

        const data =
            await response.json();

        document.getElementById("result")
            .innerHTML = `

            <h2>ATS Score: ${data.atsScore}</h2>

            <h3>Skills Found</h3>

            <ul>
                ${data.skills
                    .map(skill =>
                        `<li>${skill}</li>`)
                    .join("")}
            </ul>

            <h3>Suggestions</h3>

            <ul>
                ${data.suggestions
                    .map(suggestion =>
                        `<li>${suggestion}</li>`)
                    .join("")}
            </ul>

        `;

        document.getElementById("loading")
            .innerText = "";

    } catch (error) {

        document.getElementById("loading")
            .innerText =
            "Error connecting to API.";

        console.error(error);
    }
}