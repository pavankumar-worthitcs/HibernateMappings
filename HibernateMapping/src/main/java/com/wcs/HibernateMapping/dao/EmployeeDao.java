package com.wcs.HibernateMapping.dao;
import com.wcs.HibernateMapping.dto.Employee;
import com.wcs.HibernateMapping.dto.IdCard;
import com.wcs.HibernateMapping.dto.Project;
import com.wcs.HibernateMapping.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeDao {
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ProjectDao projectDao;

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee removeExistingProjectFromExistingEmployee(Long projectId,Long employeeId){
        Employee dbEmployee =fetchEmployeeById(employeeId);
        Project dbProject =projectDao.fetchProjectById(projectId);
        if(dbEmployee!= null && dbProject!=null){
            dbEmployee.getProjects().remove(dbProject);
            dbProject.getEmployees().remove(dbEmployee);
           return  saveEmployee(dbEmployee);

        }
        return null;
    }

    public Employee addNewProjectToExistingEmployee(Project newProject, Long employeeId){
        Employee dbEmployee =fetchEmployeeById(employeeId);
        if(dbEmployee != null){
            newProject.getEmployees().add(dbEmployee);
            dbEmployee.getProjects().add(newProject);
            return saveEmployee(dbEmployee);
        }
        return null;
    }

    public Employee addExistingProjectToExistingEmployee(Long projectId,Long employeeId){
        Employee dbEmployee =fetchEmployeeById(employeeId);
        Project dbProject = projectDao.fetchProjectById(projectId);
        if(dbEmployee != null && dbProject != null){
            dbEmployee.getProjects().add(dbProject);
            dbProject.getEmployees().add(dbEmployee);
            return saveEmployee(dbEmployee);
        }
        return null;
    }

    public Employee addNewIdCardToExistingEmployee(Long employeeId, IdCard newIdCard){
       Employee dbEmployee =fetchEmployeeById(employeeId);
       if(dbEmployee != null){
           dbEmployee.setIdCard(newIdCard);
           newIdCard.setEmployee(dbEmployee);
           return saveEmployee(dbEmployee);
       }
       return null;
    }

    public Employee fetchEmployeeById(Long employeeId){
        Optional<Employee> dbEmployee =employeeRepo.findById(employeeId);
        return dbEmployee.orElse(null);
    }
    public Employee updateEmployeeById(Long employeeId,Employee newEmployee){
        Employee dbEmployee =fetchEmployeeById(employeeId);
        if(dbEmployee!= null){
            newEmployee.setEmployeeId(employeeId);
            return saveEmployee(newEmployee);
        }
        return null;
    }
    public Employee deleteEmployeeById(Long employeeId){
        Employee dbEmployee= fetchEmployeeById(employeeId);
        if(dbEmployee!=null) employeeRepo.delete(dbEmployee);
        return dbEmployee;
    }
}
