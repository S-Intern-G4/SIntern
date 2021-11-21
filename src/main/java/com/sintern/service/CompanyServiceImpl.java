package com.sintern.service;

import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.Domain;
import com.sintern.exception.EntityNotFoundException;
import com.sintern.exception.ExistentEmailException;
import com.sintern.exception.NonExistentDomainException;
import com.sintern.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final DomainService domainService;
    private final EncryptionService encryptionService;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, DomainService domainService, EncryptionService encryptionService) {
        this.companyRepository = companyRepository;
        this.domainService = domainService;
        this.encryptionService = encryptionService;
    }

    public void addCompany(Company company) {
        Company companyFoundByEmail = companyRepository.findByEmail(company.getEmail());
        if (companyFoundByEmail != null) {
            throw new ExistentEmailException("There is already a company with this email!");
        } else {
            List<Domain> companyDomain = domainService.getDomainsByDomainType(company.getDomain().getDomainType());
            if (companyDomain.size() < 1) {
                throw new NonExistentDomainException("There are no domains with this domain type!");
            }
            company.setDomain(companyDomain.get(0));

            String encodedPassword = encryptionService.encodePassword(company.getPassword());
            company.setPassword(encodedPassword);
            companyRepository.save(company);
        }
    }

    public Company findByID(UUID uuid) {
        return companyRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("The company doesn't exist"));
    }
}