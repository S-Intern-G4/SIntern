package com.sintern.service;

import com.sintern.domain.dto.TestResultDTO;
import com.sintern.domain.entity.Student;
import com.sintern.domain.entity.Test;
import com.sintern.domain.entity.TestResponse;
import com.sintern.exception.NoTestsForOpenPositionException;
import com.sintern.repository.TestRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TestServiceImpl implements TestService {
    TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    @Transactional
    public List<TestResultDTO> getTestResultsForOpenPosition(UUID openPositionId) {
        List<Test> takenTests = testRepository.findAllByOpenInternPositionId(openPositionId);
        List<TestResultDTO> testResults = new ArrayList<>();
        if (takenTests.size() == 0) {
            throw new NoTestsForOpenPositionException("There aren't any test taken for this position yet.");
        } else {
            takenTests.forEach(takenTest -> {
                List<TestResponse> responses = takenTest.getTestResponses();
                long points = responses.stream().filter(response -> response.getQuizQuestion().isCorrect(response.getSelectedAnswer())).count();
                double grade = (points * 10.0) / takenTest.getQuiz().getQuizQuestions().size();
                Student student = takenTest.getApplication().getStudent();
                testResults.add(
                        TestResultDTO.builder()
                                .fullName(student.getFirstName() + " " + student.getLastName())
                                .email(student.getEmail())
                                .phoneNumber(student.getPhoneNumber())
                                .grade(grade)
                                .hasPassed(grade >= 5.0)
                                .build()
                );

            });
        }
        testResults.sort((o1, o2) -> (int) (o2.getGrade() - o1.getGrade()));
        return testResults;
    }

}
