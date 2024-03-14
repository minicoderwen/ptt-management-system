package org.gu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    // Create a concrete subclass of Staff for testing
    private static class TestStaff extends Staff {
        public TestStaff(int id, String name) {
            super(id, name);
        }
    }

    @Test
    void testStaffIDGetterAndSetter() {
        // Initialize a TestStaff object
        Staff staff = new TestStaff(1, "John Doe");

        // Test getter
        assertEquals(1, staff.getStaffID(), "The staff ID should be 1.");

        // Test setter
        staff.setStaffID(2);
        assertEquals(2, staff.getStaffID(), "The staff ID should have been updated to 2.");
    }

    @Test
    void testStaffNameGetterAndSetter() {
        // Initialize a TestStaff object
        Staff staff = new TestStaff(1, "John Doe");

        // Test getter
        assertEquals("John Doe", staff.getStaffName(), "The staff name should be John Doe.");

        // Test setter
        staff.setStaffName("Jane Doe");
        assertEquals("Jane Doe", staff.getStaffName(), "The staff name should have been updated to Jane Doe.");
    }
}
