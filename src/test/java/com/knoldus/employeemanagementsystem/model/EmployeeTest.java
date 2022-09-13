package com.knoldus.employeemanagementsystem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    /**
     * Methods under test:
     */
    @Test
    void testConstructor() {
        Employee actualEmployee = new Employee();
        actualEmployee.setId(123L);
        assertEquals(123L, actualEmployee.getId().longValue());
    }
}

