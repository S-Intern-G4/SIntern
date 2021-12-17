package com.sintern.api.response.transformer;

import com.sintern.api.response.GetApplicationByOpenInternPositionAndStudentResponse;
import com.sintern.domain.entity.Application;

public class GetApplicationByOpenInternPositionAndStudentTransformer {

    public static GetApplicationByOpenInternPositionAndStudentResponse transform(Application application) {
        GetApplicationByOpenInternPositionAndStudentResponse getApplicationByOpenInternPositionAndStudentResponse = new GetApplicationByOpenInternPositionAndStudentResponse();

        if (application != null) {
            getApplicationByOpenInternPositionAndStudentResponse.setApplicationID(application.getId());
        }

        return getApplicationByOpenInternPositionAndStudentResponse;
    }

}
