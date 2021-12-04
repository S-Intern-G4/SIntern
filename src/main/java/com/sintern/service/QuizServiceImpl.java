package com.sintern.service;

import com.sintern.domain.entity.OpenInternPosition;
import com.sintern.domain.entity.Quiz;
import com.sintern.domain.entity.QuizQuestion;
import com.sintern.exception.ExistentQuizException;
import com.sintern.repository.OpenInternPositionRepository;
import com.sintern.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final OpenInternPositionRepository openInternPositionRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizzRepository, OpenInternPositionRepository openInternPositionRepository) {
        this.quizRepository = quizzRepository;
        this.openInternPositionRepository = openInternPositionRepository;
    }

    @Override
    public void addQuiz(UUID openInterPositionID) {
        if(quizRepository.findByOpenInternPositionId(openInterPositionID) == null) {
            OpenInternPosition openInternPosition = openInternPositionRepository.getById(openInterPositionID);
            List<QuizQuestion> quizQuestionList = new ArrayList<>();
            Quiz quiz = new Quiz();
            quiz.setOpenInternPosition(openInternPosition);
            quiz.setQuizQuestions(quizQuestionList);
            quizRepository.save(quiz);
        }
        else {
            throw new ExistentQuizException("A quizz with the same ID already exists!");
        }
    }

    @Override
    public Quiz findById(UUID quizID) {
        return quizRepository.getById(quizID);
    }
}