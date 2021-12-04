package com.sintern.api;

import com.sintern.api.request.AddQuizRequest;
import com.sintern.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addQuiz(@RequestBody AddQuizRequest addQuizRequest){
        quizService.addQuiz(addQuizRequest.getOpenInternPositionID());
    }
}