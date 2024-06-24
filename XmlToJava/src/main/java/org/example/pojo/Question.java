package org.example.pojo;

import java.util.List;

public class Question {
    private int id;
    private String questionName;
    private List<Answer> answers;

    public Question() {}

    public Question(int id, String questionName, List<Answer> answers) {
        super();
        this.id = id;
        this.questionName = questionName;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
