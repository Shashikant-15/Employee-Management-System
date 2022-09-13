package com.knoldus.employeemanagementsystem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AddressTest {
    /**
     * Method under test: {@link Address#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Address()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Address#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Address address = new Address();

        Address address1 = new Address();
        address1.setCity("ranchi");
        address1.setHouseNo(312L);
        address1.setId(123L);
        address1.setState("Jharkhand");
        assertTrue(address.canEqual(address1));
    }

    /**
     * Methods under test:
     */
    @Test
    void testConstructor() {
        Address actualAddress = new Address();
        actualAddress.setCity("Bokaro");
        actualAddress.setHouseNo(1L);
        actualAddress.setId(13L);
        actualAddress.setState("Jharkhand");
        String actualToStringResult = actualAddress.toString();
        assertEquals("Bokaro", actualAddress.getCity());
        assertEquals(1L, actualAddress.getHouseNo().longValue());
        assertEquals(13L, actualAddress.getId().longValue());
        assertEquals("Jharkhand", actualAddress.getState());
        assertEquals("Address(id=13, houseNo=1, city=Bokaro, state=Jharkhand)", actualToStringResult);
    }

    /**
     * Methods under test:
     */
    @Test
    void testConstructor2() {
        Address actualAddress = new Address(123L, 1L, "Delhi", "Delhi");
        actualAddress.setCity("Delhi");
        actualAddress.setHouseNo(1L);
        actualAddress.setId(123L);
        actualAddress.setState("Delhi");
        String actualToStringResult = actualAddress.toString();
        assertEquals("Delhi", actualAddress.getCity());
        assertEquals(1L, actualAddress.getHouseNo().longValue());
        assertEquals(123L, actualAddress.getId().longValue());
        assertEquals("Delhi", actualAddress.getState());
        assertEquals("Address(id=123, houseNo=1, city=Delhi, state=Delhi)", actualToStringResult);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals() {
        Address address = new Address();
        address.setCity("Mumbai");
        address.setHouseNo(123L);
        address.setId(103L);
        address.setState("MH");
        assertNotEquals(address, null);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals2() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState("MD");
        assertNotEquals(address, "Different type to Address");
    }

    /**
     * Methods under test:
     */
    @Test
    void testEquals3() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState("MD");
        assertEquals(address, address);
        int expectedHashCodeResult = address.hashCode();
        assertEquals(expectedHashCodeResult, address.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Address#equals(Object)}
     *   <li>{@link Address#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertEquals(address, address1);
        int expectedHashCodeResult = address.hashCode();
        assertEquals(expectedHashCodeResult, address1.hashCode());
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals5() {
        Address address = new Address();
        address.setCity("MD");
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertNotEquals(address, address1);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals6() {
        Address address = new Address();
        address.setCity(null);
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertNotEquals(address, address1);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals7() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(3L);
        address.setId(123L);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertNotEquals(address, address1);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals8() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(null);
        address.setId(123L);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertNotEquals(address, address1);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals9() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(1L);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertNotEquals(address, address1);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals10() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(null);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertNotEquals(address, address1);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals11() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState("Oxford");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertNotEquals(address, address1);
    }

    /**
     * Method under test: {@link Address#equals(Object)}
     */
    @Test
    void testEquals12() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState(null);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertNotEquals(address, address1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Address#equals(Object)}
     *   <li>{@link Address#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        Address address = new Address();
        address.setCity(null);
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity(null);
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState("MD");
        assertEquals(address, address1);
        int expectedHashCodeResult = address.hashCode();
        assertEquals(expectedHashCodeResult, address1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Address#equals(Object)}
     *   <li>{@link Address#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(null);
        address.setId(123L);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(null);
        address1.setId(123L);
        address1.setState("MD");
        assertEquals(address, address1);
        int expectedHashCodeResult = address.hashCode();
        assertEquals(expectedHashCodeResult, address1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Address#equals(Object)}
     *   <li>{@link Address#hashCode()}
     * </ul>
     */
    @Test
    void testEquals15() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(null);
        address.setState("MD");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(null);
        address1.setState("MD");
        assertEquals(address, address1);
        int expectedHashCodeResult = address.hashCode();
        assertEquals(expectedHashCodeResult, address1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Address#equals(Object)}
     *   <li>{@link Address#hashCode()}
     * </ul>
     */
    @Test
    void testEquals16() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setHouseNo(1L);
        address.setId(123L);
        address.setState(null);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setHouseNo(1L);
        address1.setId(123L);
        address1.setState(null);
        assertEquals(address, address1);
        int expectedHashCodeResult = address.hashCode();
        assertEquals(expectedHashCodeResult, address1.hashCode());
    }
}

