package com.wcs.HibernateMapping.repo;

import com.wcs.HibernateMapping.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

   @Query("""
    select e from Employee e
    join fetch e.idCard ic
    where lower(e.employeeName) like lower(concat('%', :keyword, '%')) or
       cast(e.employeeId as string) like concat('%', :keyword, '%')
       or cast(e.employeeSalary as string) like concat('%', :keyword, '%')
       or lower(ic.idCardNumber) like lower(concat('%', :keyword, '%'))
    """)
   List<Employee> searchByKeyword(@Param("keyword") String keyword);

   @Query("""
    SELECT e FROM Employee e
    LEFT JOIN e.company c
    LEFT JOIN e.idCard i
    LEFT JOIN e.projects p
        where LOWER(e.employeeName) LIKE LOWER(CONCAT('%', :keyData, '%')) OR
        STR(e.employeeId) LIKE CONCAT('%', :keyData, '%') OR
        STR(e.employeeSalary) LIKE CONCAT('%', :keyData, '%') OR
        STR(c.companyId) LIKE CONCAT('%', :keyData, '%') OR
        LOWER(i.idCardNumber) LIKE LOWER(CONCAT('%', :keyData, '%')) OR
        LOWER(p.projectName) LIKE LOWER(CONCAT('%', :keyData, '%')) OR
        STR(i.idCardId) LIKE CONCAT('%', :keyData, '%') OR
        STR(p.projectId) LIKE CONCAT('%', :keyData, '%') OR
        LOWER(c.companyLocation) LIKE LOWER(CONCAT('%', :keyData, '%')) OR
        LOWER(c.companyName) LIKE LOWER(CONCAT('%', :keyData, '%'))
""")
   List<Employee> searchByAnyField(@Param("keyData") String keyData);



}
