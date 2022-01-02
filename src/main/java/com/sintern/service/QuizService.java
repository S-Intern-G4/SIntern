package com.sintern.service;

import com.sintern.domain.entity.Quiz;
import com.sintern.domain.entity.QuizQuestion;

import java.util.List;
import java.util.UUID;

public interface QuizService {

    void addQuiz(List<QuizQuestion> quizQuestionList, UUID openInternPositionID);

    Quiz findQuizByOpenPositionId(UUID openPositionId);
}
