package com.knoldus.learning.java.controller;

import com.knoldus.learning.java.entity.Employee;
import com.knoldus.learning.java.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee setEmployee(@RequestBody Employee employeeModel) {
        return employeeService.Save(employeeModel);
    }

    @GetMapping("/get")
    public List<Employee> fetchEmployee() {
        return employeeService.showEmployee();
    }


    @RequestMapping(value = { "delete/{id}" }, method = { RequestMethod.DELETE })
    public void delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        System.out.print("Testing: DELETION SUCCESS \n");

//    @RequestMapping("delete/{id}")
//    public void deleteAuthorizationServer(
//            @PathVariable("id") String authorizationUrl)
//            throws IOException {

    }

    @GetMapping("get/{id}")
    public Optional<Employee> fetchEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }
}
