package com.sintern.service;

import com.sintern.domain.dto.TestResponseDTO;
import com.sintern.domain.dto.TestResultDTO;
import com.sintern.domain.entity.TestResponse;
import com.sintern.exception.NoTestsForOpenPositionException;

import java.util.List;
import java.util.UUID;

public interface TestService {

    List<TestResultDTO> getTestResultsForOpenPosition(UUID openPositionId) throws NoTestsForOpenPositionException;

    void addTest(UUID quizID, UUID applicationID, List<TestResponseDTO> testResponseDTOS);
}
