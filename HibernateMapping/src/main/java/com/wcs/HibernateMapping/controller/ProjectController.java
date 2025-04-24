package com.wcs.HibernateMapping.controller;
import com.wcs.HibernateMapping.dto.Project;
import com.wcs.HibernateMapping.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("/saveProject")
    public Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @GetMapping("/fetchProjectById")
    public Project fetchProjectById(@RequestParam Long projectId) {
        return projectService.fetchProjectById(projectId);
    }

    @DeleteMapping("/deleteProjectById")
    public Project deleteProjectById(@RequestParam Long projectId) {
        return projectService.deleteProjectById(projectId);
    }

    @PutMapping("/updateProjectById")
    public Project updateProjectById(@RequestParam Long projectId,@RequestBody Project newProject) {
        return projectService.updateProjectById(projectId, newProject);
    }
}
