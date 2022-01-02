package com.sintern.api.response;

import com.sintern.domain.entity.EducationDetails;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class GetApplicationByInternPositionResponse {

    private String firstName;
    private String lastName;
    private EducationDetails educationDetails;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private UUID studentId;
    private String description;
    private LocalDateTime dateOfSubmission;

}
