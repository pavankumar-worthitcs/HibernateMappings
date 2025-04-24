package com.wcs.HibernateMapping.repo;

import com.wcs.HibernateMapping.dto.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {

}
