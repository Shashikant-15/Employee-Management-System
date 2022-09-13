package com.knoldus.employeemanagementsystem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DepartmentTest {
    /**
     * Method under test: {@link Department#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Department()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Department#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Department department = new Department();

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");
        assertTrue(department.canEqual(department1));
    }

    /**
     * Methods under test:
     */
    @Test
    void testConstructor() {
        Department actualDepartment = new Department();
        actualDepartment.setId(123L);
        actualDepartment.setName("HR");
        String actualToStringResult = actualDepartment.toString();
        assertEquals(123L, actualDepartment.getId().longValue());
        assertEquals("HR", actualDepartment.getName());
        assertEquals("Department(id=123, name=HR)", actualToStringResult);
    }

    /**
     * Methods under test:
     */
    @Test
    void testConstructor2() {
        Department actualDepartment = new Department(1123L, "Finance");
        actualDepartment.setId(1123L);
        actualDepartment.setName("Finance");
        String actualToStringResult = actualDepartment.toString();
        assertEquals(1123L, actualDepartment.getId().longValue());
        assertEquals("Finance", actualDepartment.getName());
        assertEquals("Department(id=1123, name=Finance)", actualToStringResult);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals() {
        Department department = new Department();
        department.setId(131L);
        department.setName("Name");
        assertNotEquals(department, null);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals2() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");
        assertNotEquals(department, "Different type to Department");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Department#equals(Object)}
     *   <li>{@link Department#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Name");
        assertEquals(department, department);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Department#equals(Object)}
     *   <li>{@link Department#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Department department = new Department();
        department.setId(123L);
        department.setName("Management");

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Management");
        assertEquals(department, department1);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department1.hashCode());
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals5() {
        Department department = new Department();
        department.setId(1L);
        department.setName("Name");

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals6() {
        Department department = new Department();
        department.setId(null);
        department.setName("Name");

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals7() {
        Department department = new Department();
        department.setId(123L);
        department.setName(null);

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");
        assertNotEquals(department, department1);
    }

    /**
     * Method under test: {@link Department#equals(Object)}
     */
    @Test
    void testEquals8() {
        Department department = new Department();
        department.setId(123L);
        department.setName(
                String.join("", "com.", System.getProperty("user.name"), ".employeemanagementsystem.model.Department"));

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName("Name");
        assertNotEquals(department, department1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Department#equals(Object)}
     *   <li>{@link Department#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        Department department = new Department();
        department.setId(null);
        department.setName("Name");

        Department department1 = new Department();
        department1.setId(null);
        department1.setName("Name");
        assertEquals(department, department1);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Department#equals(Object)}
     *   <li>{@link Department#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        Department department = new Department();
        department.setId(123L);
        department.setName(null);

        Department department1 = new Department();
        department1.setId(123L);
        department1.setName(null);
        assertEquals(department, department1);
        int expectedHashCodeResult = department.hashCode();
        assertEquals(expectedHashCodeResult, department1.hashCode());
    }
}

