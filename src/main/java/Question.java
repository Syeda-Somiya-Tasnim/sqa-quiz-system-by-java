import org.json.simple.JSONObject;

public class Question {
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerKey;

    public Question(String questionText, String option1, String option2, String option3, String option4,
            int answerKey) {
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerKey = answerKey;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public int getAnswerKey() {
        return answerKey;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("question", questionText);
        json.put("option 1", option1);
        json.put("option 2", option2);
        json.put("option 3", option3);
        json.put("option 4", option4);
        json.put("answerkey", answerKey);
        return json;
    }
}
