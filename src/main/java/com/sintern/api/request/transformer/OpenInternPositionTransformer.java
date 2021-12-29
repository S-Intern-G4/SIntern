package com.sintern.api.request.transformer;

import com.sintern.api.request.CreateOpenInternPositionRequest;
import com.sintern.domain.entity.OpenInternPosition;

public class OpenInternPositionTransformer {
    public static OpenInternPosition transform(CreateOpenInternPositionRequest createOpenInternPositionRequest) {
        OpenInternPosition openInternPosition = new OpenInternPosition();
        openInternPosition.setAvailablePositions(createOpenInternPositionRequest.getAvailablePositions());
        openInternPosition.setDepartment(createOpenInternPositionRequest.getDepartment());
        openInternPosition.setDescription(createOpenInternPositionRequest.getDescription());
        openInternPosition.setName(createOpenInternPositionRequest.getName());

        return openInternPosition;
    }
}
