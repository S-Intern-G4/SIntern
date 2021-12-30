package com.sintern.api;

import com.sintern.api.request.CreateTestRequest;
import com.sintern.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tests")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTest(@RequestBody CreateTestRequest createTestRequest) {
        testService.addTest(createTestRequest.getQuizID(), createTestRequest.getApplicationID(), createTestRequest.getTestResponse());
    }
}