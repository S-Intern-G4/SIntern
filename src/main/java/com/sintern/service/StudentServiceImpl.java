package com.sintern.service;

import com.sintern.domain.entity.EducationDetails;
import com.sintern.domain.entity.Student;
import com.sintern.exception.EntityNotFoundException;
import com.sintern.exception.ExistentEmailException;
import com.sintern.repository.EducationDetailsRepository;
import com.sintern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final EncryptionService encryptionService;
    private final EducationDetailsRepository educationDetailsRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, EncryptionService encryptionService, EducationDetailsRepository educationDetailsRepository) {
        this.studentRepository = studentRepository;
        this.encryptionService = encryptionService;
        this.educationDetailsRepository = educationDetailsRepository;
    }

    public void addStudent(Student student) {
        Student studentFoundByEmail = studentRepository.findByEmail(student.getEmail());
        if (studentFoundByEmail != null){
            System.out.println(studentFoundByEmail);
            throw new ExistentEmailException("There is already a student with this email!");
        } else {
            String encodedPassword = encryptionService.encodePassword(student.getPassword());
            student.setPassword(encodedPassword);
            studentRepository.save(student);
        }
    }

    public Student findById(UUID uuid) {
        return studentRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("The student doesn't exist!"));
    }

    @Override
    public Student updateStudent(Student student) {
        Student newStudent = studentRepository.findById(student.getId()).orElseThrow(() -> new EntityNotFoundException("The student doesn't exist!"));
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setDateOfBirth(student.getDateOfBirth());
        newStudent.setPhoneNumber(student.getPhoneNumber());

        EducationDetails educationDetails = educationDetailsRepository.findByStudent(student);
        EducationDetails newEducationDetails = student.getEducationDetails();

        educationDetails.setFaculty(newEducationDetails.getFaculty());
        educationDetails.setSpecialization(newEducationDetails.getSpecialization());
        educationDetails.setUniversity(newEducationDetails.getUniversity());
        educationDetails.setYearOfStudy(newEducationDetails.getYearOfStudy());

        educationDetailsRepository.save(educationDetails);
        studentRepository.save(newStudent);
        return newStudent;
    }
}
