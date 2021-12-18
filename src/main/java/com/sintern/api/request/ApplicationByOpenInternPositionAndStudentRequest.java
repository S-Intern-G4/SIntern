package com.sintern.api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ApplicationByOpenInternPositionAndStudentRequest {

    private UUID openInternPositionID;
    private UUID studentID;

}
