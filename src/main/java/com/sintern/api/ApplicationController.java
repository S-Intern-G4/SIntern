package com.sintern.api;

import com.sintern.api.request.AddApplicationRequest;
import com.sintern.api.request.ApplicationByOpenInternPositionAndStudentRequest;
import com.sintern.api.response.GetApplicationByInternPositionResponse;
import com.sintern.api.response.GetApplicationByOpenInternPositionAndStudentResponse;
import com.sintern.api.response.transformer.GetApplicationByOpenInternPositionAndStudentTransformer;
import com.sintern.domain.entity.Application;
import com.sintern.domain.entity.OpenInternPosition;
import com.sintern.domain.entity.Student;
import com.sintern.service.ApplicationService;
import com.sintern.service.FileService;
import com.sintern.service.OpenInternPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.sintern.api.response.transformer.GetApplicationTransformer.transform;

@CrossOrigin
@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    private final FileService fileService;

    private final OpenInternPositionService openInternPositionService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, FileService fileService, OpenInternPositionService openInternPositionService) {
        this.applicationService = applicationService;

        this.fileService = fileService;
        this.openInternPositionService = openInternPositionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addApplication(@RequestBody AddApplicationRequest addApplicationRequest) {
        applicationService.addApplication(addApplicationRequest.getStudentID(),
                addApplicationRequest.getOpenInternPositionID(), addApplicationRequest.getDescription());
    }

    @GetMapping("/{openInternPositionID}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetApplicationByInternPositionResponse> getApplicationsByOpenInternPositionID(@PathVariable UUID openInternPositionID) {
        OpenInternPosition openInternPosition = openInternPositionService.getOpenInternPositionById(openInternPositionID);
        List<Application> applicationList = applicationService.findApplicationsByOpenInternPosition(openInternPosition);
        List<GetApplicationByInternPositionResponse> applicationByInternPositionResponseList = new ArrayList<>();

        for (Application application : applicationList) {
            Student student = application.getStudent();
            GetApplicationByInternPositionResponse applicationResponse = transform(application, student);
            applicationByInternPositionResponseList.add(applicationResponse);
        }

        return applicationByInternPositionResponseList;
    }

    @PostMapping("/applied")
    @ResponseStatus(HttpStatus.OK)
    public GetApplicationByOpenInternPositionAndStudentResponse findApplicationByOpenInternPositionIdAndStudentId(@RequestBody ApplicationByOpenInternPositionAndStudentRequest applicationByOpenInternPositionAndStudentRequest) {
        Application application = applicationService.findApplicationsByOpenInternPositionIdAndStudentId(
                applicationByOpenInternPositionAndStudentRequest.getOpenInternPositionID(),
                applicationByOpenInternPositionAndStudentRequest.getStudentID());

        return GetApplicationByOpenInternPositionAndStudentTransformer.transform(application);
    }
}
