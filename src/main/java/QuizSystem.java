import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QuizSystem {
    private static final String USERS_FILE = "resources/users.json";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        QuizSystem system = new QuizSystem();
        system.start();
    }

    private void start() {
        System.out.println("Welcome to the Quiz System!");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        JSONObject user = authenticateUser(username, password);
        if (user != null) {
            String role = (String) user.get("role");
            if ("admin".equals(role)) {
                Admin admin = new Admin();
                admin.addQuestions();
            } else if ("student".equals(role)) {
                Student student = new Student();
                student.takeQuiz();
            }
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private JSONObject authenticateUser(String username, String password) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(USERS_FILE)) {
            JSONArray userData = (JSONArray) parser.parse(reader);
            for (Object obj : userData) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").equals(username) && user.get("password").equals(password)) {
                    return user;
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }
        return null;
    }
}
