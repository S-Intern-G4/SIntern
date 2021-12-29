package com.sintern.service;

import com.sintern.domain.dto.OpenInternPositionDTO;
import com.sintern.domain.entity.Company;
import com.sintern.domain.entity.Domain;
import com.sintern.domain.entity.OpenInternPosition;
import com.sintern.domain.enums.DomainType;
import com.sintern.repository.OpenInternPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OpenInternPositionServiceImpl implements OpenInternPositionService {

    private final OpenInternPositionRepository openInternPositionRepository;

    @Autowired
    public OpenInternPositionServiceImpl(OpenInternPositionRepository openInternPositionRepository) {
        this.openInternPositionRepository = openInternPositionRepository;
    }

    @Override
    public void addOpenInternPosition(int availablePositions, String department, String description, String name, Company company) {
        OpenInternPosition openInternPosition = new OpenInternPosition();
        openInternPosition.setAvailablePositions(availablePositions);
        openInternPosition.setDepartment(department);
        openInternPosition.setDescription(description);
        openInternPosition.setName(name);
        openInternPosition.setCompany(company);
        openInternPositionRepository.save(openInternPosition);
    }

    public OpenInternPosition getOpenInternPositionById(UUID id) {
        return openInternPositionRepository.findOpenInternPositionById(id);
    }

    public List<OpenInternPositionDTO> findOpenInternPositionDTOByCompanyAddress(String address) {
        List<OpenInternPositionDTO> openInternPositionDTOList = new ArrayList<>();

        for (OpenInternPosition openInterPosition : openInternPositionRepository.findOpenInternPositionByCompany_Address(address)) {
            OpenInternPositionDTO openInternPositionDTO = new OpenInternPositionDTO(openInterPosition.getId(), openInterPosition.getName(),
                    openInterPosition.getDepartment(), openInterPosition.getDescription(), openInterPosition.getAvailablePositions(),
                    openInterPosition.getCompany().getName(), openInterPosition.getCompany().getDomain().getDomainType(), openInterPosition.getCompany().getAddress());
            openInternPositionDTOList.add(openInternPositionDTO);
        }
        return openInternPositionDTOList;
    }

    public List<OpenInternPositionDTO> findOpenInternPositionDTOByCompanyDomain(DomainType domainType) {
        List<OpenInternPositionDTO> openInternPositionDTOList = new ArrayList<>();

        for (OpenInternPosition openInterPosition : openInternPositionRepository.findOpenInternPositionsByCompanyDomainDomainType(domainType)) {
            OpenInternPositionDTO openInternPositionDTO = new OpenInternPositionDTO(openInterPosition.getId(), openInterPosition.getName(),
                    openInterPosition.getDepartment(), openInterPosition.getDescription(), openInterPosition.getAvailablePositions(),
                    openInterPosition.getCompany().getName(), openInterPosition.getCompany().getDomain().getDomainType(), openInterPosition.getCompany().getAddress());
            openInternPositionDTOList.add(openInternPositionDTO);
        }
        return openInternPositionDTOList;
    }

    public List<Domain> getDomains() {
        List<OpenInternPosition> openInternPositions = openInternPositionRepository.findAll();
        List<Domain> domains = new ArrayList<>();

        for (OpenInternPosition openInternPosition : openInternPositions) {
            domains.add(openInternPosition.getCompany().getDomain());
        }

        return domains.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<OpenInternPositionDTO> findOpenInternPositionDTOByCompany(Company companyID) {
        List<OpenInternPositionDTO> openInternPositionDTOList = new ArrayList<>();
        for (OpenInternPosition openInterPosition : openInternPositionRepository.findOpenInternPositionsByCompany(companyID)) {
            OpenInternPositionDTO openInternPositionDTO = new OpenInternPositionDTO(openInterPosition.getId(), openInterPosition.getName(),
                    openInterPosition.getDepartment(), openInterPosition.getDescription(), openInterPosition.getAvailablePositions(),
                    openInterPosition.getCompany().getName(), openInterPosition.getCompany().getDomain().getDomainType(), openInterPosition.getCompany().getAddress());
            openInternPositionDTOList.add(openInternPositionDTO);
        }
        return openInternPositionDTOList;
    }
}
