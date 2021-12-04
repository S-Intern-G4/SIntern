package com.sintern.api;

import com.sintern.api.request.QuizzRequest;
import com.sintern.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/quizzes")
public class QuizzController {

    private final QuizzService quizService;

    @Autowired
    public QuizzController(QuizzService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addQuiz(@RequestBody QuizzRequest quizzRequest){
        quizService.addQuiz(quizzRequest.getQuizQuestionList(), quizzRequest.getOpenInternPositionID());
    }
}
