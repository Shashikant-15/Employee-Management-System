package com.knoldus.employeemanagementsystem.controller;

import com.knoldus.employeemanagementsystem.model.Employee;
import com.knoldus.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Add new employee
    @PostMapping("/addEmployee")
    public Employee addEmployee(@Valid @RequestBody Employee employee) {

        return employeeService.addEmployee(employee);
    }

    // Get employee by Id
    @GetMapping("/getByID/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {

        return employeeService.getEmployeeByID(id);
    }


    // Update employee
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("/deleteById/{id}")
    public void deleteEmployeeByID(@PathVariable Long id) {

        employeeService.deleteEmployeeByID(id);
    }

    // Get all employee
    @GetMapping("/getAll")
    public List<Employee> getAllEmployee() {

        return employeeService.getAllEmployees();
    }

}
