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

}
