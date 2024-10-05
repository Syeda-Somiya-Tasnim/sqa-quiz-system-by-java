import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Student {
    private static final String QUIZ_FILE = "resources/quiz.json";
    private static final Scanner scanner = new Scanner(System.in);

    public void takeQuiz() {
        JSONArray quizData = loadQuizData();
        Random random = new Random();
        int score = 0;
        int totalQuestions = 10;

        for (int i = 0; i < totalQuestions; i++) {
            JSONObject questionObj = (JSONObject) quizData.get(random.nextInt(quizData.size()));
            System.out.println("[Question " + (i + 1) + "] " + questionObj.get("question"));
            System.out.println("1. " + questionObj.get("option 1"));
            System.out.println("2. " + questionObj.get("option 2"));
            System.out.println("3. " + questionObj.get("option 3"));
            System.out.println("4. " + questionObj.get("option 4"));

            System.out.print("Your answer (1-4): ");
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer == (long) questionObj.get("answerkey")) {
                score++;
            }
        }

        displayResult(score);
    }

    private JSONArray loadQuizData() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(QUIZ_FILE)) {
            return (JSONArray) parser.parse(reader);
        } catch (IOException | ParseException e) {
            System.out.println("Error loading quiz data: " + e.getMessage());
            return new JSONArray();
        }
    }

    private void displayResult(int score) {
        System.out.println("You scored: " + score + " out of 10");

        if (score >= 8) {
            System.out.println("Excellent! You have got " + score + " out of 10");
        } else if (score >= 5) {
            System.out.println("Good. You have got " + score + " out of 10");
        } else if (score >= 2) {
            System.out.println("Very poor! You have got " + score + " out of 10");
        } else {
            System.out.println("Very sorry you are failed. You have got " + score + " out of 10");
        }
    }
}
