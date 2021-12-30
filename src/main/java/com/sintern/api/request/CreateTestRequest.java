package com.sintern.api.request;

import com.sintern.domain.dto.TestResponseDTO;

import java.util.List;
import java.util.UUID;

public class CreateTestRequest {
    private UUID quizID;
    private UUID applicationID;
    private List<TestResponseDTO> testResponse;

    public UUID getQuizID() {
        return quizID;
    }

    public void setQuizID(UUID quizID) {
        this.quizID = quizID;
    }

    public UUID getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(UUID applicationID) {
        this.applicationID = applicationID;
    }

    public List<TestResponseDTO> getTestResponse() {
        return testResponse;
    }

    public void setTestResponse(List<TestResponseDTO> testResponse) {
        this.testResponse = testResponse;
    }
}
