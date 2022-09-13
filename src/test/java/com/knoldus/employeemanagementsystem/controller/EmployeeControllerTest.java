package com.knoldus.employeemanagementsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.employeemanagementsystem.model.Department;
import com.knoldus.employeemanagementsystem.model.Designation;
import com.knoldus.employeemanagementsystem.model.Employee;
import com.knoldus.employeemanagementsystem.service.EmployeeService;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeController#addEmployee(Employee)}
     */
    @Test
    void testAddEmployee() throws Exception {
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
        employee.setEmail("deepu.kumar@example.org");
        employee.setId(123L);
        employee.setName("Deepak");
        when(employeeService.addEmployee((Employee) any())).thenReturn(employee);

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Deepak");

        Designation designation1 = new Designation();
        designation1.setDesignationName("Designation Name");
        designation1.setExperience(1);
        designation1.setId(123L);
        designation1.setSalary(1);

        Employee employee1 = new Employee();
        employee1.setDepartment(department1);
        employee1.setDesignation(designation1);
        employee1.setEmail("deepu.kumar@example.org");
        employee1.setId(123L);
        employee1.setName("name");
        String content = (new ObjectMapper()).writeValueAsString(employee1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/addEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Deepak\",\"email\":\"deepu.kumar@example.org\",\"designation\":{\"id\":123,\"designationName\":\"Designation"
                                        + " Name\",\"experience\":1,\"salary\":1},\"department\":{\"id\":123,\"name\":\"Name\"}}"));
    }

    /**
     * Method under test: {@link EmployeeController#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee() throws Exception {
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
        when(employeeService.updateEmployee((Employee) any())).thenReturn(employee);

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
        String content = (new ObjectMapper()).writeValueAsString(employee1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/employee/updateEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"designation\":{\"id\":123,\"designationName\":\"Designation"
                                        + " Name\",\"experience\":1,\"salary\":1},\"department\":{\"id\":123,\"name\":\"Name\"}}"));
    }

    /**
     * Method under test: {@link EmployeeController#deleteEmployeeByID(Long)}
     */
    @Test
    void testDeleteEmployeeByID() throws Exception {
        doNothing().when(employeeService).deleteEmployeeByID((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employee/deleteById/{id}", 123L);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link EmployeeController#deleteEmployeeByID(Long)}
     */
    @Test
    void testDeleteEmployeeByID2() throws Exception {
        doNothing().when(employeeService).deleteEmployeeByID((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/employee/deleteById/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link EmployeeController#getAllEmployee()}
     */
    @Test
    void testGetAllEmployee() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/getAll");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#getAllEmployee()}
     */
    @Test
    void testGetAllEmployee2() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/employee/getAll");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#getEmployeeById(Long)}
     */
    @Test
    void testGetEmployeeById() throws Exception {
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
        when(employeeService.getEmployeeByID((Long) any())).thenReturn(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/getByID/{id}", 123L);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"email\":\"jane.doe@example.org\",\"designation\":{\"id\":123,\"designationName\":\"Designation"
                                        + " Name\",\"experience\":1,\"salary\":1},\"department\":{\"id\":123,\"name\":\"Name\"}}"));
    }

    /**
     * Method under test: {@link EmployeeController#getEmployeeByName(String)}
     */
    @Test
    void testGetEmployeeByName() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/getByName");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }
}

