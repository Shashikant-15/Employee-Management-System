package com.knoldus.employeemanagementsystem.controller;

import com.knoldus.employeemanagementsystem.model.Department;
import com.knoldus.employeemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public Department addDepartment(@Valid @RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    // Get employee by I'd
    @GetMapping("/getByID/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }


    // Update employee
    @PutMapping("/updateEmployee")
    public Department updateEmployee(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    // Delete employee
    @DeleteMapping("/deleteById/{id}")
    public void deleteDepartmentByID(@PathVariable Long id) {

        departmentService.deleteDepartmentByID(id);
    }

    // Get all employee
    @GetMapping("/getAll")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }
}
