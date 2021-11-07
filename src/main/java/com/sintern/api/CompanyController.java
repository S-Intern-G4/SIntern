package com.sintern.api;

import com.sintern.domain.Company;
import com.sintern.service.CompanyService;
import com.sintern.service.EncryptionService;
import com.sintern.service.EncryptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping("/register")
    public void processRegister(@RequestBody Company company) {
        companyService.addCompany(company);
    }

}