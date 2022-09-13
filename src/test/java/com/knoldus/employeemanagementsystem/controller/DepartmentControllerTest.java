package com.knoldus.employeemanagementsystem.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.employeemanagementsystem.model.Department;
import com.knoldus.employeemanagementsystem.service.DepartmentService;
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

@ContextConfiguration(classes = {DepartmentController.class})
@ExtendWith(SpringExtension.class)
class DepartmentControllerTest {
    @Autowired
    private DepartmentController departmentController;

    @MockBean
    private DepartmentService departmentService;

    /**
     * Method under test: {@link DepartmentController#addDepartment(Department)}
     */
    @Test
    void testAddDepartment() throws Exception {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");
        when(departmentService.addDepartment((Department) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(department1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/department/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link DepartmentController#getDepartmentById(Long)}
     */
    @Test
    void testGetDepartmentById() throws Exception {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");
        when(departmentService.getDepartmentById((Long) any())).thenReturn(department);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/department/{id}", 123L);
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link DepartmentController#deleteDepartmentByID(Long)}
     */
    @Test
    void testDeleteDepartmentByID() throws Exception {
        doNothing().when(departmentService).deleteDepartmentByID((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/department/deleteById/{id}", 123L);
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link DepartmentController#deleteDepartmentByID(Long)}
     */
    @Test
    void testDeleteDepartmentByID2() throws Exception {
        doNothing().when(departmentService).deleteDepartmentByID((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/department/deleteById/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link DepartmentController#getAllDepartment()}
     */
    @Test
    void testGetAllDepartment() throws Exception {
        when(departmentService.getAllDepartment()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/department/getAll");
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DepartmentController#getAllDepartment()}
     */
    @Test
    void testGetAllDepartment2() throws Exception {
        when(departmentService.getAllDepartment()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/department/getAll");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DepartmentController#getDepartmentByName(String)}
     */
    @Test
    void testGetDepartmentByName() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/department/getByID/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }

    /**
     * Method under test: {@link DepartmentController#updateEmployee(Department)}
     */
    @Test
    void testUpdateEmployee() throws Exception {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");
        when(departmentService.updateDepartment((Department) any())).thenReturn(department);

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(department1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/department/updateEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(departmentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }
}

