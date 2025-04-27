package com.wcs.HibernateMapping.controller;

import com.wcs.HibernateMapping.dto.Employee;
import com.wcs.HibernateMapping.dto.IdCard;
import com.wcs.HibernateMapping.dto.Project;
import com.wcs.HibernateMapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/addNewIdCardToExistingEmployee")
    public Employee addNewIdCardToExistingEmployee(@RequestParam Long employeeId,@RequestBody IdCard newIdCard){
        return employeeService.addNewIdCardToExistingEmployee(employeeId,newIdCard);
    }

    @GetMapping("/searchKey")
    public ResponseEntity<Object> searchByKeyword(@RequestParam String keyword){
        return employeeService.searchByKeyword(keyword);
    }

    @PutMapping("/addNewProjectToExistingEmployee")
    public Employee addNewProjectToExistingEmployee(@RequestBody Project newProject,@RequestParam Long employeeId){
        return employeeService.addNewProjectToExistingEmployee(newProject,employeeId);
    }

    @GetMapping("/searchByAnyKey")
    public ResponseEntity<Object> searchByAnyKey(@RequestParam String key){
        if(key.isEmpty()){
            return ResponseEntity.badRequest().body("Please Enter any data");
        }
        return employeeService.searchByAnyKey(key.trim());
    }

    @PutMapping("/addExistingProjectToExistingEmployee")
    public Employee addExistingProjectToExistingEmployee(@RequestParam Long projectId,@RequestParam Long employeeId){
        return employeeService.addExistingProjectToExistingEmployee(projectId,employeeId);
    }

    @PutMapping("/removeExistingProjectFromExistingEmployee")
    public Employee removeExistingProjectFromExistingEmployee(@RequestParam Long projectId,@RequestParam Long employeeId){
        return employeeService.removeExistingProjectFromExistingEmployee(projectId,employeeId);
    }

    @GetMapping("/fetchEmployeeById")
    public Employee fetchEmployeeById(@RequestParam Long employeeId) {
        return employeeService.fetchEmployeeById(employeeId);
    }

    @DeleteMapping("/deleteEmployeeById")
    public Employee deleteEmployeeById(@RequestParam Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

    @GetMapping("/updateEmployeeById")
    public Employee updateEmployeeById(@RequestParam Long employeeId,@RequestBody Employee newEmployee) {
        return employeeService.updateEmployeeById(employeeId, newEmployee);
    }
}
