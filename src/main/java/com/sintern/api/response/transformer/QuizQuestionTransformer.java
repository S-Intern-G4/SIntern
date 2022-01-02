package com.sintern.api.response.transformer;

import com.sintern.domain.dto.QuizQuestionDTO;
import com.sintern.domain.entity.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestionTransformer {
    public static List<QuizQuestionDTO> transform(List<QuizQuestion> quizQuestions){
        List<QuizQuestionDTO> quizQuestionDTOS = new ArrayList<>();
        for(QuizQuestion question : quizQuestions){
            QuizQuestionDTO dto = new QuizQuestionDTO();
            dto.setId(question.getId());
            dto.setQuestion(question.getQuestion());
            dto.setAnswer1(question.getAnswer1());
            dto.setAnswer2(question.getAnswer2());
            dto.setAnswer3(question.getAnswer3());
            dto.setAnswer4(question.getAnswer4());
            dto.setCorrectAnswerIndex(question.getCorrectAnswerIndex());
            quizQuestionDTOS.add(dto);
        }
        return quizQuestionDTOS;
    }
}
