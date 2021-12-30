package com.sintern.domain.dto;

import java.util.UUID;

public class TestResponseDTO {
    private UUID quizQuestionID;
    private int selectedAnswerIndex;

    public TestResponseDTO(UUID quizQuestionID, int selectedAnswerIndex) {
        this.quizQuestionID = quizQuestionID;
        this.selectedAnswerIndex = selectedAnswerIndex;
    }

    public UUID getQuizQuestionID() {
        return quizQuestionID;
    }

    public void setQuizQuestionID(UUID quizQuestionID) {
        this.quizQuestionID = quizQuestionID;
    }

    public int getSelectedAnswerIndex() {
        return selectedAnswerIndex;
    }

    public void setSelectedAnswerIndex(int selectedAnswerIndex) {
        this.selectedAnswerIndex = selectedAnswerIndex;
    }

    @Override
    public String toString() {
        return "TestResponseDTO{" +
                "quizQuestionID=" + quizQuestionID +
                ", selectedAnswerIndex=" + selectedAnswerIndex +
                '}';
    }
}

