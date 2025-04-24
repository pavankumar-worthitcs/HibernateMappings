package com.wcs.HibernateMapping.controller;
import com.wcs.HibernateMapping.dto.Company;
import com.wcs.HibernateMapping.dto.Employee;
import com.wcs.HibernateMapping.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/saveCompany")
    public Company saveCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @GetMapping("/fetchCompanyById")
    public Company fetchCompanyById(@RequestParam Long companyId) {
        return companyService.fetchCompanyById(companyId);
    }

    @DeleteMapping("/deleteCompanyById")
    public Company deleteCompanyById(@RequestParam Long companyId) {
        return companyService.deleteCompanyById(companyId);
    }
    @PutMapping("/addExistingEmployeeToExistingCompany")
    public Company addExistingEmployeeToExistingCompany(@RequestParam Long companyId,@RequestParam Long employeeId){
        return  companyService.addExistingEmployeeToExistingCompany(companyId,employeeId);
    }

    @PutMapping("/addNewEmployeeToExistingCompany")
    public Company addNewEmployeeToExistingCompany(@RequestParam Long companyId,@RequestBody Employee newEmployee){
        return companyService.addNewEmployeeToExistingCompany(companyId,newEmployee);
    }

    @PutMapping("/updateCompanyById")
    public Company updateCompanyById(@RequestParam Long companyId,@RequestBody Company newCompany) {
        return companyService.updateCompanyById(companyId, newCompany);
    }

}
    

