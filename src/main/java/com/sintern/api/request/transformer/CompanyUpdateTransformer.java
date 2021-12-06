package com.sintern.api.request.transformer;

import com.sintern.api.request.CompanyUpdateRequest;
import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.Domain;
import com.sintern.domain.enums.DomainType;
import com.sintern.exception.NonExistentDomainException;

public class CompanyUpdateTransformer {
    public static Company transform(CompanyUpdateRequest companyUpdateRequest){
        Company company = new Company();
        company.setId(companyUpdateRequest.getId());
        company.setName(companyUpdateRequest.getName());
        company.setAddress(companyUpdateRequest.getAddress());

        Domain domain = new Domain();
        try {
            domain.setDomainType(DomainType.valueOf(companyUpdateRequest.getDomain()));
        } catch (IllegalArgumentException exception) {
            throw new NonExistentDomainException("There are no domains with this domain type!");
        }
        company.setDomain(domain);

        return company;
    }
}
