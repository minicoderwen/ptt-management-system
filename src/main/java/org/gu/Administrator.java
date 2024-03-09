package org.gu;

import org.contract.*;

/**
 * 
 * Administrator.java
 * 
 * Administrator class represents the administrator in the university,
 * responsible for checking the requirements added by the class director and
 * allocates appropriate part-time teacher to the requests raised.
 * 
 * Implements the View and Edit interfaces, allowing to view Part-time teachers
 * and Requirements list, and edit appropraite fields in the list
 * (PTT List - AssignedTrainings and Availability, Req List - AssignedPTTs)
 * 
 */

public class Administrator extends Staff implements View, Edit {

    public Administrator(int Id, String name) {
        super(Id, name);
    }

    /**
     * editPartTimeTeachersData ()
     * 
     * Implements logic to allow the administrator to update
     * the PTTs Training details in the Teacher DB corresponding
     * to the given staffID
     * 
     * @param staffID (int)
     * 
     */
    public void editPartTimeTeacherData(int staffID) {
        // TO DO
        // If you edit the function signature make sure to update the interface
    }

    /**
     * editRequirement
     * 
     * Implements logic to allow the administrator to update
     * the ASSIGNEDPTT field in the requirement DB corresponding
     * to the given reqID
     * 
     * @param reqID (String)
     */
    public void editRequirement(int reqID) {
        // TO DO
        // If you edit the function signature make sure to update the interface
    }

    /**
     * viewRequirements
     * 
     * Implements logic to allow the administrator to view
     * all entries in the requirement DB
     * 
     */
    public void viewRequirements() {
        // TO DO
        // Access the requirement database and print it in console

    }

    /**
     * viewPartTimeTeachersData
     * 
     * Implements logic to allow the administrator to view
     * all entries in the Teachers DB
     * 
     */
    public void viewPartTimeTeachersData() {
        // TO DO
    }

    /**
     * viewPartTimeTeacherData
     * 
     * Implements logic to allow the administrator to view
     * all entries in the requirement DB
     * 
     */
    public void viewPartTimeTeacherData(int staffID) {
        // TO DO
        // Access the teachers database and print it in console
    }

    /**
     * viewRequirements
     * 
     * Implements logic to allow the administrator to view
     * all entries in the requirement DB
     * 
     */
    public void viewRequirement(int reqID) {
        // TO DO
    }

}
