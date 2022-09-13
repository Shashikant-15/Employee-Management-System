package com.knoldus.employeemanagementsystem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DesignationTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Designation#Designation()}
     *   <li>{@link Designation#setId(Long)}
     *   <li>{@link Designation#getId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Designation actualDesignation = new Designation();
        actualDesignation.setId(123L);
        assertEquals(123L, actualDesignation.getId().longValue());
    }
}

