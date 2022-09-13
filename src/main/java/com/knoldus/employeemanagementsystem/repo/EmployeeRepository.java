package com.knoldus.employeemanagementsystem.repo;

import com.knoldus.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee getByName(String name);
//
    Employee findByName(String name);
}
