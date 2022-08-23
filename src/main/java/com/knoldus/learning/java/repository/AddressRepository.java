package com.knoldus.learning.java.repository;

import com.knoldus.learning.java.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Employee,Integer> {
}
