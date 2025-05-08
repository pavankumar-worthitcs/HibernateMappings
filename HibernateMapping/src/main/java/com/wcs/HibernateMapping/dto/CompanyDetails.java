package com.wcs.HibernateMapping.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


   @Entity
    @Table(name = "company_details")
   public class CompanyDetails {
       public CompanyDetails(String companyName, String companyLocation, String employeeNames) {
           this.companyName = companyName;
           this.companyLocation = companyLocation;
           this.employeeNames = employeeNames;
       }

       public CompanyDetails() {
       }

       @Id
        @Column(name = "company_name")
        private String companyName;

       @Column(name = "company_location")
        private String companyLocation;

       public String getCompanyName() {
           return companyName;
       }

       public void setCompanyName(String companyName) {
           this.companyName = companyName;
       }

       public String getCompanyLocation() {
           return companyLocation;
       }

       public void setCompanyLocation(String companyLocation) {
           this.companyLocation = companyLocation;
       }

       public String getEmployeeNames() {
           return employeeNames;
       }

       public void setEmployeeNames(String employeeNames) {
           this.employeeNames = employeeNames;
       }

       @Column(name = "employee_names")
        private String employeeNames;
    }

