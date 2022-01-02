package com.sintern.domain.dto;

import java.util.UUID;

public class QuizQuestionDTO {
    UUID id;

    String question;

    String answer1;

    String answer2;

    String answer3;

    String answer4;

    int correctAnswerIndex;

    public QuizQuestionDTO() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
