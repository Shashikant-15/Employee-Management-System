package com.knoldus.learning.java.service;

import com.knoldus.learning.java.entity.Employee;
import com.knoldus.learning.java.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    List<Employee> employeeList = new ArrayList<>();

    public Employee Save(Employee employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public List<Employee> showEmployee() {
        employeeList = (List<Employee>) employeeRepository.findAll();
        return employeeList;
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
