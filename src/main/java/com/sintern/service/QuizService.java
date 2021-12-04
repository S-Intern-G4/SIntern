package com.sintern.service;

import com.sintern.domain.entity.Quiz;

import java.util.UUID;

public interface QuizService {

    void addQuiz(UUID openInterPositionID);

    Quiz findById(UUID quizID);
}
