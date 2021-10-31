package com.sintern.repository;

import com.sintern.domain.EducationDetails;
import com.sintern.domain.UniversityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EducationDetailsRepository extends JpaRepository<EducationDetails, UUID> {

    List<EducationDetails> findEducationDetailsByUniversity(UniversityType universityType);
}
