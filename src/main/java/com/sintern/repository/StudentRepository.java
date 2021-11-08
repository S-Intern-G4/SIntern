package com.sintern.repository;

import com.sintern.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);
}