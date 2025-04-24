package com.wcs.HibernateMapping.service;

import com.wcs.HibernateMapping.dao.EmployeeDao;
import com.wcs.HibernateMapping.dto.Employee;
import com.wcs.HibernateMapping.dto.IdCard;
import com.wcs.HibernateMapping.dto.Project;
import com.wcs.HibernateMapping.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeRepo employeeRepo;



    public Employee saveEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

    public ResponseEntity<Object> searchByKeyword(String keyword){
        List<Employee> filtered = employeeRepo.searchByKeyword(keyword);
        if(filtered.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                    .body("No matching data found ");
        }
        return ResponseEntity.ok(filtered);
    }
    public Employee addNewProjectToExistingEmployee(Project newProject, Long employeeId){
        return employeeDao.addNewProjectToExistingEmployee(newProject,employeeId);
    }

    public Employee addExistingProjectToExistingEmployee(Long projectId,Long employeeId){
      return employeeDao.addExistingProjectToExistingEmployee(projectId,employeeId);
    }

    public Employee addNewIdCardToExistingEmployee(Long employeeId, IdCard newIdCard){
        return employeeDao.addNewIdCardToExistingEmployee(employeeId,newIdCard);
    }

    public Employee fetchEmployeeById(Long employeeId) {
        return employeeDao.fetchEmployeeById(employeeId);
    }

    public Employee deleteEmployeeById(Long employeeId) {
        return employeeDao.deleteEmployeeById(employeeId);
    }

    public Employee updateEmployeeById(Long employeeId, Employee newEmployee) {
        return employeeDao.updateEmployeeById(employeeId, newEmployee);
    }
}
