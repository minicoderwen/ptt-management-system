package org.gu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RequirementTest {

    private Requirement requirement;
    private Course course;

    @BeforeEach
    void setUp() {
        // Adjusted to use String for courseID and include the requiredExpertise
        course = new Course("CS101", "Introduction to Mathematics", "Basic Math");

        // Initialize a Requirement object with the new Course object
        requirement = new Requirement(1, course, 2, "Basic Teaching Training", "");
    }

    @Test
    void testGetRequirementID() {
        assertEquals(1, requirement.getRequirementID(), "Requirement ID should match the initialized value.");
    }

    @Test
    void testSetRequirementID() {
        requirement.setRequirementID(2);
        assertEquals(2, requirement.getRequirementID(), "Requirement ID should be updated.");
    }

    @Test
    void testGetAndSetCourseDetail() {
        // Adjusted to include requiredExpertise in the new Course object
        Course newCourse = new Course("CS102", "Advanced Mathematics", "Advanced Math");
        requirement.setCourseDetail(newCourse);
        assertEquals(newCourse, requirement.getCourseDetail(), "Course detail should be updated.");
    }

    @Test
    void testGetAndSetRequiredNumberOfPTTs() {
        requirement.setRequiredNumberOfPTTs(3);
        assertEquals(3, requirement.getRequiredNumberOfPTTs(), "Number of PTTs required should be updated.");
    }

    @Test
    void testGetAndSetRequiredTrainings() {
        requirement.setRequiredTrainings("Advanced Teaching Training");
        assertEquals("Advanced Teaching Training", requirement.getRequiredTrainings(), "Required trainings should be updated.");
    }

    @Test
    void testGetAndSetAssignedPTTs() {
        requirement.setAssignedPTTs("John Doe, Jane Doe");
        assertEquals("John Doe, Jane Doe", requirement.getAssignedPTTs(), "Assigned PTTs should be updated.");
    }

    @Test
    void testToString() {
        String expectedOutput = String.format("%-10s %-10s %-40s %-15s %-30s %s", 1,
                "CS101", "Introduction to Mathematics",
                2, "Basic Teaching Training", "");
        assertEquals(expectedOutput.trim(), requirement.toString().trim(), "toString output should match the expected format.");
    }
}
