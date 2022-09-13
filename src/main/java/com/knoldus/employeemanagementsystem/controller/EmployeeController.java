package com.knoldus.employeemanagementsystem.controller;

import com.knoldus.employeemanagementsystem.model.Employee;
import com.knoldus.employeemanagementsystem.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * here EmployeeController class used to describe...
 * the get,post,or update the value of employee of our api
 */
@RestController
@RequestMapping("/employee")
@Api(value = "Employee api controller",tags = "EMPLOYEE API")
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


    @GetMapping("/getByName")
    public Employee getEmployeeByName(@PathVariable String name) {

        return employeeService.getEmployeeByName(name);
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
