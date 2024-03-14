package org.gu;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
class AdministratorTest {

    @Mock
    private DatabaseManager databaseManager;

    @Mock
    private Scanner scanner;

    private Administrator administrator;

    @BeforeEach
    void setUp() {
        DatabaseManager.setInstance(databaseManager);
        administrator = new Administrator(1, "Test Admin");
    }

    @Test
    void editPartTimeTeacherData_TeacherExists_UpdatesSuccessfully() {
        int staffID = 1;
        String newTraining = "Advanced Teaching";
        when(databaseManager.teacherExists(staffID)).thenReturn(true);
        Teacher mockTeacher = mock(Teacher.class);
        when(databaseManager.getPartTimeTeacher(staffID)).thenReturn(mockTeacher);
        when(scanner.nextLine()).thenReturn(newTraining);

        // When
        administrator.editPartTimeTeacherData(scanner, staffID);

        // Then
        verify(databaseManager, times(1)).teacherExists(staffID);
        verify(databaseManager, times(1)).getPartTimeTeacher(staffID);
        verify(mockTeacher, times(1)).updateTrainingDetails(newTraining);
        verify(databaseManager, times(1)).updateTeacher(mockTeacher);
    }

    @Test
    void editRequirement_RequirementExists_UpdatesSuccessfully() {
        // Given
        int reqID = 100;
        String assignedPTTs = "2,3,4";
        when(databaseManager.requirementExists(reqID)).thenReturn(true);
        Requirement mockRequirement = mock(Requirement.class);
        when(databaseManager.getRequirement(reqID)).thenReturn(mockRequirement);
        when(scanner.nextLine()).thenReturn(assignedPTTs);

        // When
        administrator.editRequirement(scanner, reqID);

        // Then
        verify(databaseManager, times(1)).requirementExists(reqID);
        verify(databaseManager, times(1)).getRequirement(reqID);
        verify(mockRequirement, times(1)).setAssignedPTTs(assignedPTTs);
        verify(databaseManager, times(1)).updateRequirement(mockRequirement);
    }
}
