package com.knoldus.employeemanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.knoldus.employeemanagementsystem.model.Department;
import com.knoldus.employeemanagementsystem.model.Designation;
import com.knoldus.employeemanagementsystem.model.Employee;
import com.knoldus.employeemanagementsystem.repo.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeService.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeService#addEmployee(Employee)}
     */
    @Test
    void testAddEmployee() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");

        Designation designation = new Designation();
        designation.setDesignationName("Designation Name");
        designation.setExperience(1);
        designation.setId(123L);
        designation.setSalary(1);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setEmail("hr.doe@example.org");
        employee.setId(123L);
        employee.setName("HR");
        when(employeeRepository.save((Employee) any())).thenReturn(employee);

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");

        Designation designation1 = new Designation();
        designation1.setDesignationName("Designation Name");
        designation1.setExperience(1);
        designation1.setId(123L);
        designation1.setSalary(1);

        Employee employee1 = new Employee();
        employee1.setDepartment(department1);
        employee1.setDesignation(designation1);
        employee1.setEmail("finance.doe@example.org");
        employee1.setId(123L);
        employee1.setName("Finance");
        assertSame(employee, employeeService.addEmployee(employee1));
        verify(employeeRepository).save((Employee) any());
    }

    /**
     * Method under test: {@link EmployeeService#getEmployeeByID(Long)}
     */
    @Test
    void testGetEmployeeByID() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");

        Designation designation = new Designation();
        designation.setDesignationName("Designation Name");
        designation.setExperience(1);
        designation.setId(123L);
        designation.setSalary(1);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setEmail("jane.doe@example.org");
        employee.setId(123L);
        employee.setName("Name");
        Optional<Employee> ofResult = Optional.of(employee);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(employee, employeeService.getEmployeeByID(123L));
        verify(employeeRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#getEmployeeByName(String)}
     */
    @Test
    void testGetEmployeeByName() {
        Department department = new Department();
        department.setId(113L);
        department.setName("Name");

        Designation designation = new Designation();
        designation.setDesignationName("Designation Name");
        designation.setExperience(1);
        designation.setId(113L);
        designation.setSalary(1);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setEmail("knoldus.doe@example.org");
        employee.setId(113L);
        employee.setName("Deepak");
        when(employeeRepository.findByName((String) any())).thenReturn(employee);
        assertSame(employee, employeeService.getEmployeeByName("Deepak"));
        verify(employeeRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link EmployeeService#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");

        Designation designation = new Designation();
        designation.setDesignationName("Designation Name");
        designation.setExperience(1);
        designation.setId(123L);
        designation.setSalary(1);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setEmail("jane.doe@example.org");
        employee.setId(123L);
        employee.setName("Name");

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");

        Designation designation1 = new Designation();
        designation1.setDesignationName("Designation Name");
        designation1.setExperience(1);
        designation1.setId(123L);
        designation1.setSalary(1);

        Employee employee1 = new Employee();
        employee1.setDepartment(department1);
        employee1.setDesignation(designation1);
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(123L);
        employee1.setName("Name");
        Optional<Employee> ofResult = Optional.of(employee1);
        when(employeeRepository.save((Employee) any())).thenReturn(employee);
        when(employeeRepository.findById((Long) any())).thenReturn(ofResult);

        Department department2 = new Department();
        department2.setId(123L);
        department2.setName("Name");

        Designation designation2 = new Designation();
        designation2.setDesignationName("Designation Name");
        designation2.setExperience(1);
        designation2.setId(123L);
        designation2.setSalary(1);

        Employee employee2 = new Employee();
        employee2.setDepartment(department2);
        employee2.setDesignation(designation2);
        employee2.setEmail("jane.doe@example.org");
        employee2.setId(123L);
        employee2.setName("Name");
        assertSame(employee2, employeeService.updateEmployee(employee2));
        verify(employeeRepository).save((Employee) any());
        verify(employeeRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee3() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");

        Designation designation = new Designation();
        designation.setDesignationName("Designation Name");
        designation.setExperience(1);
        designation.setId(123L);
        designation.setSalary(1);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setEmail("jane.doe@example.org");
        employee.setId(123L);
        employee.setName("Name");
        when(employeeRepository.save((Employee) any())).thenReturn(employee);
        when(employeeRepository.findById((Long) any())).thenReturn(Optional.empty());

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");

        Designation designation1 = new Designation();
        designation1.setDesignationName("Designation Name");
        designation1.setExperience(1);
        designation1.setId(123L);
        designation1.setSalary(1);

        Employee employee1 = new Employee();
        employee1.setDepartment(department1);
        employee1.setDesignation(designation1);
        employee1.setEmail("jane.doe@example.org");
        employee1.setId(123L);
        employee1.setName("Name");
        assertSame(employee, employeeService.updateEmployee(employee1));
        verify(employeeRepository).save((Employee) any());
        verify(employeeRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link EmployeeService#deleteEmployeeByID(Long)}
     */
    @Test
    void testDeleteEmployeeByID() {
        doNothing().when(employeeRepository).deleteById((Long) any());
        employeeService.deleteEmployeeByID(123L);
        verify(employeeRepository).deleteById((Long) any());
        assertTrue(employeeService.getAllEmployees().isEmpty());
    }

    /**
     * Method under test: {@link EmployeeService#getAllEmployees()}
     */
    @Test
    void testGetAllEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> actualAllEmployees = employeeService.getAllEmployees();
        assertSame(employeeList, actualAllEmployees);
        assertTrue(actualAllEmployees.isEmpty());
        verify(employeeRepository).findAll();
    }
}

