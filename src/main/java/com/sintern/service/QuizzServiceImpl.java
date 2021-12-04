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
public class QuizzServiceImpl implements QuizzService {

    private final QuizRepository quizRepository;
    private final OpenInternPositionRepository openInternPositionRepository;

    @Autowired
    public QuizzServiceImpl(QuizRepository quizzRepository, OpenInternPositionRepository openInternPositionRepository) {
        this.quizRepository = quizzRepository;
        this.openInternPositionRepository = openInternPositionRepository;
    }

    @Override
    public void addQuiz(List<QuizQuestion> quizQuestionList, UUID openInterPositionID) {
        if(quizRepository.findByOpenInternPositionId(openInterPositionID) == null) {
            OpenInternPosition openInternPosition = openInternPositionRepository.getById(openInterPositionID);
            Quiz quiz = new Quiz();
            quiz.setQuizQuestions(quizQuestionList);
            quiz.setOpenInternPosition(openInternPosition);
            quizQuestionList.forEach(quizQuestion -> quizQuestion.setQuiz(quiz));
            quizRepository.save(quiz);
        }
        else {
            throw new ExistentQuizException("A quizz with the same ID already exists!");
        }
    }
}