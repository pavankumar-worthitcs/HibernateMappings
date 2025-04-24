package com.wcs.HibernateMapping.dao;

import com.wcs.HibernateMapping.dto.Company;
import com.wcs.HibernateMapping.dto.Employee;
import com.wcs.HibernateMapping.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyDao {

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    EmployeeDao employeeDao;

    public Company saveCompany(Company company){
        return companyRepo.save(company);
    }

    public Company addNewEmployeeToExistingCompany(Long companyId, Employee newEmployee){
        Company dbCompany=fetchCompanyById(companyId);
        if(dbCompany != null && ! ( dbCompany.getEmployeesList().contains(newEmployee))){
            newEmployee.setCompany(dbCompany); // setting the current company to new employee
            dbCompany.getEmployeesList().add(newEmployee); //adding them to company list
            return saveCompany(dbCompany);

        }
        return null;
    }
    public Company addExistingEmployeeToExistingCompany(Long companyId,Long employeeId){
        Company dbCompany=fetchCompanyById(companyId);
         Employee dbEmployee =employeeDao.fetchEmployeeById(employeeId);
        if(dbCompany != null && dbEmployee != null){
            dbEmployee.setCompany(dbCompany); // setting the current company to existing employee
            dbCompany.getEmployeesList().add(dbEmployee); //adding them to company list
            return saveCompany(dbCompany);

        }
        return null;
    }

    public Company fetchCompanyById(Long companyId){
        Optional<Company> dbCompany =companyRepo.findById(companyId);
        return dbCompany.orElse(null);
    }
    public Company updateCompanyById(Long companyId,Company newCompany){
        Company dbCompany =fetchCompanyById(companyId);
        if(dbCompany!= null){
            newCompany.setCompanyId(companyId);
            return saveCompany(newCompany);
        }
        return null;
    }
    public Company deleteCompanyById(Long companyId){
        Company dbCompany= fetchCompanyById(companyId);
        if(dbCompany!=null) companyRepo.delete(dbCompany);
        return dbCompany;
    }
}
