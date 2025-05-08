package com.wcs.HibernateMapping.controller;
import com.wcs.HibernateMapping.dto.CompanyDetails;
import com.wcs.HibernateMapping.service.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyDetailsController {

    @Autowired
    CompanyDetailsService companyDetailsService;

    @GetMapping("/getCompanyDetailsView")
    public List<CompanyDetails> getCompanyDetailsView(){
        return companyDetailsService.getCompanyDetailsView();
    }
}
