package com.sintern.api.response.transformer;

import com.sintern.api.response.GetQuizResponse;
import com.sintern.domain.entity.Quiz;

public class GetQuizTransformer {

    public static GetQuizResponse transform(Quiz quiz){
        GetQuizResponse getQuizResponse = new GetQuizResponse();
        getQuizResponse.setId(quiz.getId());
        getQuizResponse.setQuestions(QuizQuestionTransformer.transform(quiz.getQuizQuestions()));
        return getQuizResponse;
    }
}
