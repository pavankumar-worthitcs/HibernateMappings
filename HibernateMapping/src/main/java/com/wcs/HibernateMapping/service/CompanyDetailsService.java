package com.wcs.HibernateMapping.service;

import com.wcs.HibernateMapping.dto.CompanyDetails;
import com.wcs.HibernateMapping.repo.CompanyDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyDetailsService {

    @Autowired
    CompanyDetailsRepo companyDetailsRepo;


    public List<CompanyDetails> getCompanyDetailsView(){
        return companyDetailsRepo.findAll();
    }
}
