package com.sintern.api;

import com.sintern.api.request.AddQuizQuestionRequest;
import com.sintern.domain.entity.QuizQuestion;
import com.sintern.service.QuizQuestionService;
import com.sintern.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/quizz-questions")
public class QuizQuestionController {

    private final QuizService quizService;
    private final QuizQuestionService quizQuestionService;

    @Autowired
    public QuizQuestionController(QuizService quizService, QuizQuestionService quizQuestionService) {
        this.quizService = quizService;
        this.quizQuestionService = quizQuestionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    void addQuizQuestion(@RequestBody AddQuizQuestionRequest addQuizQuestionRequest){
        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setQuestion(addQuizQuestionRequest.getQuestion());
        quizQuestion.setAnswer1(addQuizQuestionRequest.getAnswer1());
        quizQuestion.setAnswer2(addQuizQuestionRequest.getAnswer2());
        quizQuestion.setAnswer3(addQuizQuestionRequest.getAnswer3());
        quizQuestion.setAnswer4(addQuizQuestionRequest.getAnswer4());
        quizQuestion.setCorrectAnswer(addQuizQuestionRequest.getCorrectAnswer());
        quizQuestion.setQuiz(quizService.findById(addQuizQuestionRequest.getQuizID()));
        quizQuestionService.addQuizQuestion(quizQuestion);
    }
}
