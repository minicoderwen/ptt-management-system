package org.gu;

import org.contract.*;

import java.util.Scanner;

/**
 * Administrator.java
 * <p>
 * Administrator class represents the administrator in the university,
 * responsible for checking the requirements added by the class director and
 * allocates appropriate part-time teacher to the requests raised.
 * <p>
 * Implements the View and Edit interfaces, allowing to view Part-time teachers
 * and Requirements list, and edit appropriate fields in the list
 * (PTT List - AssignedTrainings and Availability, Req List - AssignedPTTs)
 */

public class Administrator extends Staff implements Edit {

    public Administrator(int Id, String name) {
        super(Id, name);
    }

    /**
     * editPartTimeTeachersData ()
     * <p>
     * Implements logic to allow the administrator to update
     * the PTTs Training details in the Teacher DB corresponding
     * to the given staffID
     *
     * @param scanner (Scanner)
     * @param staffID (int)
     */
    public void editPartTimeTeacherData(Scanner scanner, int staffID) {
        try {
            // Check if requirement ID already exists
            if (!DatabaseManager.getInstance().teacherExists(staffID)) {
                throw new IllegalArgumentException("Teacher with ID " + staffID + " not found");
            }

            System.out.println("Please enter the assigned training: ");
            String newAssignedTrainings = scanner.nextLine();

            Teacher teacher = DatabaseManager.getInstance().getPartTimeTeacher(staffID);
            teacher.updateTrainingDetails(newAssignedTrainings);

            DatabaseManager.getInstance().updateTeacher(teacher);
            System.out.println("The data has been updated successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input format. Please try again.");
            e.printStackTrace();
        }
    }

    /**
     * editRequirement
     * <p>
     * Implements logic to allow the administrator to update
     * the ASSIGNEDPTT field in the requirement DB corresponding
     * to the given reqID
     *
     * @param scanner (Scanner)
     * @param reqID   (int)
     */
    public void editRequirement(Scanner scanner, int reqID) {
        try {
            // Check if requirement ID already exists
            if (!DatabaseManager.getInstance().requirementExists(reqID)) {
                throw new IllegalArgumentException("Requirement ID " + reqID + " not found");
            }

            System.out.println("Please enter the IDs of PTTs to be assigned");
            String newRequirement = scanner.nextLine();

            Requirement newReq = DatabaseManager.getInstance().getRequirement(reqID);
            newReq.setAssignedPTTs(newRequirement);

            DatabaseManager.getInstance().updateRequirement(newReq);
            System.out.println("The assigned PTTs for the requirement have been updated successfully!");

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred while adding the requirement. Please try again.");
            e.printStackTrace();
        }
    }
}