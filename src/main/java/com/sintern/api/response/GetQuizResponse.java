package com.sintern.api.response;

import com.sintern.domain.entity.QuizQuestion;

import java.util.List;
import java.util.UUID;

public class GetQuizResponse {
    UUID id;

    List<QuizQuestion> questions;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setQuestions(List<QuizQuestion> questions) {
        this.questions = questions;
    }

    public UUID getId() {
        return id;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }
}
