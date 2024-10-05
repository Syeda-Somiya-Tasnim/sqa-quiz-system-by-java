# SQA Quiz Management System

## Problem Statement

The SQA Quiz Management System is a software application that allows administrators to create and manage multiple-choice questions (MCQs) for students. The admin can add questions with four options and their corresponding answer keys, while students can log in to take quizzes from a bank of questions.

## Features

- **Admin Login**: Admin users can log in to add new questions to the quiz bank.
- **Student Login**: Students can log in to take quizzes.
- **MCQ Management**: Admin can save multiple MCQs with options and answer keys in a `quiz.json` file.
- **Random Question Selection**: When students take a quiz, 10 random questions are presented from the quiz bank.
- **Result Calculation**: The system calculates the score based on the student's answers.

## Technologies Used

- **Programming Language**: Java
- **Data Storage**: JSON
- **IDE**: IntelliJ IDEA
- **Library**: json-simple (for JSON parsing)

## Installation Instructions

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/Syeda-Somiya-Tasnim/sqa-quiz-system-by-java.git
   ```
2. Navigate to the project directory:
   ```bash
    cd sqa-quiz-system-by-java
   ```
3. **Open the project in IntelliJ IDEA**.

4. **Download the `json-simple-1.1.1.jar` file** from the following link:
   - [Download json-simple](https://github.com/fangyidong/json-simple/blob/master/src/json-simple-1.1.1.jar?raw=true)

5. **Add the downloaded `json-simple-1.1.1.jar` file to your project's libraries**:
   - In IntelliJ IDEA, right-click on the project in the Project view.
   - Select **Open Module Settings**.
   - Under **Libraries**, click the **+** icon to add the JAR file.
   - Locate and select the downloaded `json-simple-1.1.1.jar` file.

6. **Create a `.gitignore` file** to ignore unnecessary files and folders. Add the following content to the `.gitignore` file:
```bash
 .idea/
.gradle/
build/

   ```
## Project Structure
![image](https://github.com/user-attachments/assets/0b9dd23d-5c40-4caf-a0dd-0435e84791a2)
## Usage Instructions

1. Run the `QuizSystem.java` file to start the application.
2. Follow the on-screen instructions to log in as either an **admin** or a **student**.
3. Admins can add questions until they choose to quit by pressing **'q'**.
4. Students can take quizzes by pressing **'s'** to start the quiz.


