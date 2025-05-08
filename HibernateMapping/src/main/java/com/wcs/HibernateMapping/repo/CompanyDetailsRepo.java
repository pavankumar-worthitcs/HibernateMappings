package com.wcs.HibernateMapping.repo;


import com.wcs.HibernateMapping.dto.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetails, String> {


}
