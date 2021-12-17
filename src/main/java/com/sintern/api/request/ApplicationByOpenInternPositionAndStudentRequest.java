package com.sintern.api.request;

import java.util.UUID;

public class ApplicationByOpenInternPositionAndStudentRequest {

    private UUID openInternPositionID;
    private UUID studentID;

    public UUID getStudentID() {
        return studentID;
    }

    public void setStudentID(UUID studentID) {
        this.studentID = studentID;
    }

    public UUID getOpenInternPositionID() {
        return openInternPositionID;
    }

    public void setOpenInternPositionID(UUID openInternPositionID) {
        this.openInternPositionID = openInternPositionID;
    }
}
