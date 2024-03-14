package org.gu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void testCourseConstructorWithAllParams() {
        Course course = new Course("CS101", "Introduction to Mathematics", "Basic Math");
        assertNotNull(course, "Course should be successfully instantiated.");
        assertEquals("CS101", course.getCourseID(), "Course ID should match the constructor parameter.");
        assertEquals("Introduction to Mathematics", course.getCourseName(), "Course name should match the constructor parameter.");
        assertEquals("Basic Math", course.getRequiredExpertise(), "Required expertise should match the constructor parameter.");
    }

    @Test
    void testCourseConstructorWithoutExpertise() {
        Course course = new Course("CS102", "Calculus I");
        assertNotNull(course, "Course should be successfully instantiated.");
        assertEquals("CS102", course.getCourseID(), "Course ID should match the constructor parameter.");
        assertEquals("Calculus I", course.getCourseName(), "Course name should match the constructor parameter.");
        assertEquals("", course.getRequiredExpertise(), "Required expertise should be empty when not specified.");
    }

    @Test
    void testSetCourseID() {
        Course course = new Course("CS101", "Introduction to Mathematics", "Basic Math");
        course.setCourseID("CS103");
        assertEquals("CS103", course.getCourseID(), "Course ID should be updated.");
    }

    @Test
    void testSetCourseName() {
        Course course = new Course("CS101", "Introduction to Mathematics", "Basic Math");
        course.setCourseName("Discrete Mathematics");
        assertEquals("Discrete Mathematics", course.getCourseName(), "Course name should be updated.");
    }

    @Test
    void testSetRequiredExpertise() {
        Course course = new Course("CS101", "Introduction to Mathematics", "Basic Math");
        course.setRequiredExpertise("Algebra");
        assertEquals("Algebra", course.getRequiredExpertise(), "Required expertise should be updated.");
    }

    @Test
    void testToString() {
        Course course = new Course("CS101", "Introduction to Mathematics", "Basic Math");
        String expectedOutput = String.format("%-5s %-35s %s", "CS101", "Introduction to Mathematics", "Basic Math");
        assertEquals(expectedOutput.trim(), course.toString().trim(), "toString output should match the expected format.");
    }
}