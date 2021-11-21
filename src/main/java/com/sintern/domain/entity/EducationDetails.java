package com.sintern.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sintern.domain.enums.FacultyType;
import com.sintern.domain.enums.SpecializationType;
import com.sintern.domain.enums.UniversityType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationDetails {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    UniversityType university;
    FacultyType faculty;
    SpecializationType specialization;
    String yearOfStudy;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;
}
