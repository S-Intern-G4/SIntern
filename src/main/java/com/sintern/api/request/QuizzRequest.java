package com.sintern.api.request;

import com.sintern.domain.entity.QuizQuestion;

import java.util.List;
import java.util.UUID;

public class QuizzRequest {

    private List<QuizQuestion> quizQuestionList;
    private UUID openInternPositionID;

    public List<QuizQuestion> getQuizQuestionList() {
        return quizQuestionList;
    }

    public void setQuizQuestionList(List<QuizQuestion> quizQuestionList) {
        this.quizQuestionList = quizQuestionList;
    }

    public UUID getOpenInternPositionID() {
        return openInternPositionID;
    }

    public void setOpenInternPositionID(UUID openInternPositionID) {
        this.openInternPositionID = openInternPositionID;
    }
}
