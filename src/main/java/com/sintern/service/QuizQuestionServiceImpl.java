package com.sintern.service;

import com.sintern.domain.entity.QuizQuestion;
import com.sintern.exception.EntityNotFoundException;
import com.sintern.repository.QuizQuestionRepository;
import com.sintern.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizQuestionServiceImpl implements QuizQuestionService{
    private final QuizRepository quizRepository;
    private final QuizQuestionRepository quizQuestionRepository;

    @Autowired
    public QuizQuestionServiceImpl(QuizRepository quizRepository, QuizQuestionRepository quizQuestionRepository) {
        this.quizRepository = quizRepository;
        this.quizQuestionRepository = quizQuestionRepository;
    }

    @Override
    public void addQuizQuestion(QuizQuestion quizQuestion) {
        if(quizRepository.findById(quizQuestion.getQuiz().getId()).isEmpty()){
            throw new EntityNotFoundException("The quiz with that quizID does not exist!");
        }
        quizQuestionRepository.save(quizQuestion);
    }
}