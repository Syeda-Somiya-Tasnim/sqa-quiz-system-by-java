import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class Admin {
    private static final String QUIZ_FILE = "resources/quiz.json";
    private static final Scanner scanner = new Scanner(System.in);

    public void addQuestions() {
        while (true) {
            System.out.print("Input your question: ");
            String questionText = scanner.nextLine();

            System.out.print("Input option 1: ");
            String option1 = scanner.nextLine();
            System.out.print("Input option 2: ");
            String option2 = scanner.nextLine();
            System.out.print("Input option 3: ");
            String option3 = scanner.nextLine();
            System.out.print("Input option 4: ");
            String option4 = scanner.nextLine();
            System.out.print("What is the answer key? (1-4): ");
            int answerKey = Integer.parseInt(scanner.nextLine());

            saveQuestion(questionText, option1, option2, option3, option4, answerKey);

            System.out.print("Do you want to add more questions? (press s for start and q for quit): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                break;
            }
        }
    }

    private void saveQuestion(String questionText, String option1, String option2, String option3, String option4,
            int answerKey) {
        Question question = new Question(questionText, option1, option2, option3, option4, answerKey);
        JSONObject questionObj = question.toJSON();

        JSONArray quizData = loadQuizData();
        quizData.add(questionObj);

        try (FileWriter file = new FileWriter(QUIZ_FILE)) {
            file.write(quizData.toJSONString());
            file.flush();
        } catch (IOException e) {
            System.out.println("Error saving quiz data: " + e.getMessage());
        }

        System.out.println("Saved successfully!");
    }

    private JSONArray loadQuizData() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(QUIZ_FILE)) {
            return (JSONArray) parser.parse(reader);
        } catch (IOException | ParseException e) {
            return new JSONArray(); // Return empty array if file not found
        }
    }
}
