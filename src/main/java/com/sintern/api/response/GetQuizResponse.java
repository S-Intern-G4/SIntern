package com.sintern.api.response;

import com.sintern.domain.dto.QuizQuestionDTO;

import java.util.List;
import java.util.UUID;

public class GetQuizResponse {
    UUID id;

    List<QuizQuestionDTO> questions;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setQuestions(List<QuizQuestionDTO> questions) {
        this.questions = questions;
    }

    public UUID getId() {
        return id;
    }

    public List<QuizQuestionDTO> getQuestions() {
        return questions;
    }
}
