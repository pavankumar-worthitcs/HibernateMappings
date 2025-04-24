package com.wcs.HibernateMapping.service;

import com.wcs.HibernateMapping.dao.ProjectDao;
import com.wcs.HibernateMapping.dto.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectDao projectDao;

    public Project saveProject(Project project) {
        return projectDao.saveProject(project);
    }

    public Project fetchProjectById(Long projectId) {
        return projectDao.fetchProjectById(projectId);
    }

    public Project deleteProjectById(Long projectId) {
        return projectDao.deleteProjectById(projectId);
    }

    public Project updateProjectById(Long projectId, Project newProject) {
        return projectDao.updateProjectById(projectId, newProject);
    }
}
