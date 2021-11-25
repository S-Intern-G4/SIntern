package com.sintern.api.request.transformer;

import com.sintern.api.request.UpdateStudentRequest;
import com.sintern.domain.entity.EducationDetails;
import com.sintern.domain.entity.Student;
import com.sintern.domain.enums.FacultyType;
import com.sintern.domain.enums.SpecializationType;
import com.sintern.domain.enums.UniversityType;

public class UpdateStudentTransformer {

    public static Student transform(UpdateStudentRequest updateStudentRequest){
        Student student = new Student();
        student.setId(updateStudentRequest.getId());
        student.setFirstName(updateStudentRequest.getFirstName());
        student.setLastName(updateStudentRequest.getLastName());
        student.setDateOfBirth(updateStudentRequest.getDateOfBirth());
        student.setPhoneNumber(updateStudentRequest.getPhoneNumber());

        EducationDetails educationDetails = new EducationDetails();
        educationDetails.setSpecialization(SpecializationType.valueOf(updateStudentRequest.getSpecialization()));
        educationDetails.setFaculty(FacultyType.valueOf(updateStudentRequest.getFaculty()));
        educationDetails.setUniversity(UniversityType.valueOf(updateStudentRequest.getUniversity()));
        educationDetails.setYearOfStudy(updateStudentRequest.getYearOfStudy());

        student.setEducationDetails(educationDetails);
        educationDetails.setStudent(student);
        return student;
    }
}
