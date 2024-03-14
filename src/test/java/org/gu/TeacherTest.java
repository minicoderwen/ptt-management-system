package org.gu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private Teacher teacher;

    @BeforeEach
    void setUp() {
        // Initialize a Teacher object before each test
        teacher = new Teacher(1, "John Doe", "Mathematics");
    }

    @Test
    void testTeacherConstructorWithExpertise() {
        // Test the constructor with expertise
        assertNotNull(teacher);
        assertEquals("Mathematics", teacher.getExpertise());
        assertTrue(teacher.getAvailability());
        assertEquals("", teacher.getAssignedTrainings());
    }

    @Test
    void testTeacherConstructorWithExpertiseAndTrainings() {
        // Test the constructor with expertise and trainings
        Teacher teacherWithTrainings = new Teacher(2, "Jane Doe", "Physics", "Basic Teaching Training");
        assertNotNull(teacherWithTrainings);
        assertEquals("Physics", teacherWithTrainings.getExpertise());
        assertEquals("Basic Teaching Training", teacherWithTrainings.getAssignedTrainings());
        assertFalse(teacherWithTrainings.getAvailability());
    }

    @Test
    void testUpdateTrainingDetails() {
        // Test updating training details only
        teacher.updateTrainingDetails("Advanced Teaching Training");
        assertEquals("Advanced Teaching Training", teacher.getAssignedTrainings());
        assertFalse(teacher.getAvailability());
    }

    @Test
    void testUpdateTrainingDetailsWithAvailability() {
        // Test updating training details along with availability
        teacher.updateTrainingDetails("Advanced Teaching Training", true);
        assertEquals("Advanced Teaching Training", teacher.getAssignedTrainings());
        assertTrue(teacher.getAvailability());
    }

    @Test
    void testSetExpertise() {
        // Test setting expertise
        teacher.setExpertise("Biology");
        assertEquals("Biology", teacher.getExpertise());
    }

    @Test
    void testToString() {
        // Test the toString method for correct formatting
        String expectedOutput = "1     John Doe        Mathematics                    Yes";
        assertEquals(expectedOutput.trim(), teacher.toString().trim());
    }
}
