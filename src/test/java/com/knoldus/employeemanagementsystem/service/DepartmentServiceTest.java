package com.knoldus.employeemanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.knoldus.employeemanagementsystem.model.Department;
import com.knoldus.employeemanagementsystem.repo.DepartmentRepository;
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

@ContextConfiguration(classes = {DepartmentService.class})
@ExtendWith(SpringExtension.class)
class DepartmentServiceTest {
    @MockBean
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    /**
     * Method under test: {@link DepartmentService#addDepartment(Department)}
     */
    @Test
    void testAddDepartment() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");
        when(departmentRepository.save((Department) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");
        assertSame(department, departmentService.addDepartment(department1));
        verify(departmentRepository).save((Department) any());
    }

    /**
     * Method under test: {@link DepartmentService#getDepartmentById(Long)}
     */
    @Test
    void testGetDepartmentById() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");
        Optional<Department> ofResult = Optional.of(department);
        when(departmentRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(department, departmentService.getDepartmentById(123L));
        verify(departmentRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link DepartmentService#getAllDepartment()}
     */
    @Test
    void testGetAllDepartment() {
        ArrayList<Department> departmentList = new ArrayList<>();
        when(departmentRepository.findAll()).thenReturn(departmentList);
        List<Department> actualAllDepartment = departmentService.getAllDepartment();
        assertSame(departmentList, actualAllDepartment);
        assertTrue(actualAllDepartment.isEmpty());
        verify(departmentRepository).findAll();
    }

    /**
     * Method under test: {@link DepartmentService#updateDepartment(Department)}
     */
    @Test
    void testUpdateDepartment() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Finance");
        Optional<Department> ofResult = Optional.of(department);
        when(departmentRepository.findById((Long) any())).thenReturn(ofResult);

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Finance");
        assertSame(department, departmentService.updateDepartment(department1));
        verify(departmentRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link DepartmentService#deleteDepartmentByID(Long)}
     */
    @Test
    void testDeleteDepartmentByID() {
        doNothing().when(departmentRepository).deleteById((Long) any());
        departmentService.deleteDepartmentByID(123L);
        verify(departmentRepository).deleteById((Long) any());
        assertTrue(departmentService.getAllDepartment().isEmpty());
    }
}

