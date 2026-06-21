# 🧠 Quiz App

A desktop quiz application built with **Java Swing** that tests users' general knowledge across history, science, literature, and geography — complete with a countdown timer, score tracking, and a feedback system.

---

## 📸 Preview

The app consists of three screens that guide the user through the full quiz experience:

| Screen | Description |
|--------|-------------|
| **Login** | Enter your name and ID to begin |
| **Quiz** | Answer 10 multiple-choice questions with a 30-second timer per question |
| **Score** | View your result out of 10 and leave optional feedback |

---

## ✨ Features

- **User Login** — Collects the player's name and ID before starting
- **10 Multiple-Choice Questions** — Covering general knowledge topics (history, science, geography, literature)
- **30-Second Countdown Timer** — Automatically advances to the next question when time runs out; turns red when under 10 seconds
- **Real-Time Score Calculation** — Answers are evaluated and a final score out of 10 is displayed
- **Feedback Form** — Players can submit written feedback after completing the quiz
- **Clean GUI** — Built entirely with Java Swing with custom fonts, colors, and background images

---

## 🗂️ Project Structure

```
Quiz-app/
├── src/
│   └── App/
│       ├── Login.java      # Login screen — collects user name and ID
│       ├── Quiz.java       # Main quiz screen — questions, timer, answer logic
│       └── Score.java      # Results screen — score display and feedback form
├── bin/
│   └── classes/            # Compiled .class files
├── src/icons/
│   ├── login.jpg           # Background image for the login screen
│   ├── quiz.jpg            # Background image for the quiz screen
│   ├── score.jpg           # Background image for the score screen
│   └── crown.png           # Trophy/crown icon on the score screen
├── .gitignore              # Ignored files
└── README.md
```

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 8+)
- **GUI Framework:** Java Swing (`javax.swing`, `java.awt`)
- **IDE Recommended:** VS Code with the [Java Extension Pack](https://code.visualstudio.com/docs/languages/java)

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- [Java JDK 8 or higher](https://www.oracle.com/java/technologies/downloads/)
- [VS Code](https://code.visualstudio.com/) with the [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/Quiz-app.git
   cd Quiz-app
   ```

2. **Open in VS Code:**
   ```bash
   code .
   ```

3. **Run the application:**
   - Open `src/App/Login.java`
   - Click the **Run** button above the `main` method, or press `F5`

> The app launches with the **Login** screen. Enter any name and ID to start the quiz.

---

## 🎮 How to Play

1. On the **Login screen**, enter your name and student/player ID, then click **Next**
2. On the **Quiz screen**, read each question and select one of the four radio button options
3. Click **Next** to move to the following question — or wait for the 30-second timer to expire (the question auto-advances)
4. After the 10th question, click **Submit** to finish
5. On the **Score screen**, view your result out of 10 and optionally write feedback, then click **Send**

---

## 📋 Quiz Topics

The quiz covers the following general knowledge categories:

- 🌍 World Geography
- 📜 History
- 🔬 Science & Chemistry
- 📚 Literature
- 🧬 Biology

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m "Add your feature"`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Open a Pull Request
