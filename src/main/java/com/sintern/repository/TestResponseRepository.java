package com.sintern.repository;

import com.sintern.domain.entity.TestResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestResponseRepository extends JpaRepository<TestResponse, UUID> {
}
