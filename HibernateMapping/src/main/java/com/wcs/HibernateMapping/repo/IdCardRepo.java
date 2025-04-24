package com.wcs.HibernateMapping.repo;

import com.wcs.HibernateMapping.dto.IdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdCardRepo extends JpaRepository<IdCard,Long> {

}
