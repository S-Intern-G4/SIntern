package com.sintern.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder(toBuilder = true)
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestResultDTO {
    double grade;
    String fullName;
    String phoneNumber;
    String email;
    Boolean hasPassed;
}
