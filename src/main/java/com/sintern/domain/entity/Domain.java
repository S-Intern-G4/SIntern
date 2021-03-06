package com.sintern.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sintern.domain.enums.DomainType;
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
public class Domain {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "uuid")
    UUID id;

    String description;

    DomainType domainType;

    @OneToOne(mappedBy = "domain")
    DomainImage domainImage;

    @JsonIgnore
    @OneToMany(mappedBy = "domain")
    List<Company> companies;
}
