package com.wcs.HibernateMapping.dao;

import com.wcs.HibernateMapping.dto.Project;
import com.wcs.HibernateMapping.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProjectDao {

    @Autowired
    ProjectRepo projectRepo;

    public Project saveProject(Project project){
        return projectRepo.save(project);
    }

    public Project fetchProjectById(Long projectId){
        Optional<Project> dbProject =projectRepo.findById(projectId);
        return dbProject.orElse(null);
    }
    public Project updateProjectById(Long projectId,Project newProject){
        Project dbProject =fetchProjectById(projectId);
        if(dbProject!= null){
            newProject.setProjectId(projectId);
            return saveProject(newProject);
        }
        return null;
    }
    public Project deleteProjectById(Long projectId){
        Project dbProject= fetchProjectById(projectId);
        if(dbProject!=null) projectRepo.delete(dbProject);
        return dbProject;
    }
}
