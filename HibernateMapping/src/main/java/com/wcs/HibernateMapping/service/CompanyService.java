package com.wcs.HibernateMapping.service;

import com.wcs.HibernateMapping.dao.CompanyDao;
import com.wcs.HibernateMapping.dto.Company;
import com.wcs.HibernateMapping.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyDao companyDao;

    public Company saveCompany(Company company) {
        return companyDao.saveCompany(company);
    }

    public Company fetchCompanyById(Long companyId) {
        return companyDao.fetchCompanyById(companyId);
    }

    public Company addNewEmployeeToExistingCompany(Long companyId, Employee newEmployee){
        return companyDao.addNewEmployeeToExistingCompany(companyId,newEmployee);
    }

    public Company deleteCompanyById(Long companyId) {
        return companyDao.deleteCompanyById(companyId);
    }
    public Company addExistingEmployeeToExistingCompany(Long companyId,Long employeeId){
      return  companyDao.addExistingEmployeeToExistingCompany(companyId,employeeId);
    }

    public Company updateCompanyById(Long companyId, Company newCompany) {
        return companyDao.updateCompanyById(companyId, newCompany);
    }


        }