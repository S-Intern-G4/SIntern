package com.sintern.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestResponse {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    Test test;

    @ManyToOne
    @JoinColumn(name = "quizz_question_id", referencedColumnName = "id")
    QuizQuestion quizQuestion;

    int selectedAnswerIndex;

}
