package com.sintern.repository;

import com.sintern.domain.DomainType;
import com.sintern.domain.OpenInternPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OpenInternPositionRepository extends JpaRepository<OpenInternPosition, UUID> {
    List<OpenInternPosition> findOpenInternPositionByCompany_Address(String companyAddress);
    List<OpenInternPosition> findOpenInternPositionsByCompanyDomainDomainType(DomainType domainType);
}
