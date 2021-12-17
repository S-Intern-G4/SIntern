package com.sintern.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Test {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    Application application;

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    Quiz quiz;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test", cascade = CascadeType.ALL)
    List<TestResponse> testResponses;
}
