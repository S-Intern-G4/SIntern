package com.sintern.service;

import com.sintern.domain.entity.Quiz;
import com.sintern.domain.entity.QuizQuestion;

import java.util.List;
import java.util.UUID;

public interface QuizzService {

    void addQuiz(List<QuizQuestion> quizQuestionList, UUID openInterPositionID);
}
