package com.sintern.api.request;

import java.util.UUID;

public class AddQuizQuestionRequest {

    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String correctAnswer;
    UUID quizID;

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public UUID getQuizID() {
        return quizID;
    }
}