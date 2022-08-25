package com.knoldus.employeemanagementsystem.service;

import com.knoldus.employeemanagementsystem.model.Department;
import com.knoldus.employeemanagementsystem.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.findById(department.getId()).orElse(null);
    }

    public void deleteDepartmentByID(Long id) {
        departmentRepository.deleteById(id);
    }

}
