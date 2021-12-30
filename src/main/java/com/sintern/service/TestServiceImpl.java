package com.sintern.service;

import com.sintern.domain.dto.TestResponseDTO;
import com.sintern.domain.dto.TestResultDTO;
import com.sintern.domain.entity.Quiz;
import com.sintern.domain.entity.Student;
import com.sintern.domain.entity.Test;
import com.sintern.domain.entity.TestResponse;
import com.sintern.exception.ExistentQuizException;
import com.sintern.exception.NoTestsForOpenPositionException;
import com.sintern.repository.*;
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
    private final TestRepository testRepository;
    private final QuizRepository quizRepository;
    private final ApplicationRepository applicationRepository;
    private final TestResponseRepository testResponseRepository;
    private final QuizQuestionRepository quizQuestionRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository, QuizRepository quizRepository, ApplicationRepository applicationRepository, TestResponseRepository testResponseRepository, QuizQuestionRepository quizQuestionRepository) {
        this.testRepository = testRepository;
        this.quizRepository = quizRepository;
        this.applicationRepository = applicationRepository;
        this.testResponseRepository = testResponseRepository;
        this.quizQuestionRepository = quizQuestionRepository;
    }

    @Override
    @Transactional
    public List<TestResultDTO> getTestResultsForOpenPosition(UUID openPositionId) {
        List<Test> takenTests = testRepository.findAllByOpenInternPositionId(openPositionId);
        List<TestResultDTO> testResults = new ArrayList<>();
        if (takenTests.size() == 0) {
            throw new NoTestsForOpenPositionException("There aren't any test taken for this position yet.");
        }
        takenTests.forEach(takenTest -> {
            List<TestResponse> responses = takenTest.getTestResponses();
            long points = responses.stream().filter(response -> response.getQuizQuestion().isCorrect(response.getSelectedAnswerIndex())).count();
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
        testResults.sort((o1, o2) -> (int) (o2.getGrade() - o1.getGrade()));

        return testResults;
    }

    @Override
    @Transactional
    public void addTest(UUID quizID, UUID applicationID, List<TestResponseDTO> testResponseDTOS) {
        List<TestResponse> testResponseList = new ArrayList<>();
        Test test = testRepository.findByApplication_IdAndQuiz_Id(applicationID, quizID);
        if(test == null) {
            Test test1 = new Test();
            test1.setQuiz(quizRepository.getById(quizID));
            test1.setApplication(applicationRepository.getById(applicationID));
            testResponseDTOS.forEach(testResponseDTO -> {
                TestResponse response = new TestResponse();
                response.setTest(test1);
                response.setQuizQuestion(quizQuestionRepository.getById(testResponseDTO.getQuizQuestionID()));
                response.setSelectedAnswerIndex(testResponseDTO.getSelectedAnswerIndex());
                testResponseList.add(response);
                testResponseRepository.save(response);
            });
            test1.setTestResponses(testResponseList);
            testRepository.save(test1);
        }
        else {
            throw new ExistentQuizException("A test with this applicationID and quizID already exists!");
        }
    }
}