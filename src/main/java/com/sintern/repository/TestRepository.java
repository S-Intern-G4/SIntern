package com.sintern.repository;

import com.sintern.domain.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TestRepository extends JpaRepository<Test, UUID> {
    @Query("select t from Test t where t.application.openInternPosition.id = ?1")
    List<Test> findAllByOpenInternPositionId(UUID openInternPositionId);

    Test findByApplication_IdAndQuiz_Id(UUID applicationID, UUID quizID);
}