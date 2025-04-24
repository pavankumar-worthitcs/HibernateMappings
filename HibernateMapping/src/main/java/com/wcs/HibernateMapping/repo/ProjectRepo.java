package com.wcs.HibernateMapping.repo;

import com.wcs.HibernateMapping.dto.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Long> {

}
