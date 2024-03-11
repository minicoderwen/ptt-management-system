package org.gu;

import org.contract.*;

import java.util.List;
import java.util.Scanner;

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
        List<Teacher> teachers = DatabaseManager.getInstance().getPartTimeTeachers();
        boolean found = false; //if found the need edit teacher ID
        for (Teacher teacher : teachers) {
            if (teacher.getStaffID() == staffID) {
                found = true;
                //edit PTT data
                updateTeacherTraining(teacher);
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot found the teacher with provided ID");
        }
    }
    private void updateTeacherTraining(Teacher teacher) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please enter the assigned training: ");
            String newAssignedTrainings = scanner.nextLine();

            teacher.updateTrainingDetails(newAssignedTrainings);

            DatabaseManager.getInstance().updateTeacher(teacher.getStaffID(), newAssignedTrainings);
            System.out.println("The data has been updated successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input format. Please try again.");
        }finally {
            scanner.close();
        }
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
        List<Requirement> requirements = DatabaseManager.getInstance().getRequirements();
        boolean found = false;
        for (Requirement requirement : requirements) {
            if (requirement.getRequirementID() == reqID) {
                found = true;
                updateAssignedPTTs(requirement);
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot find the requirement with the provided ID.");
        }
    }
    private void updateAssignedPTTs(Requirement requirement){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please enter the new assigned PTTs: ");
            String newAssignedPTTs = scanner.nextLine();

            requirement.setAssignedPTTs(newAssignedPTTs);

            DatabaseManager.getInstance().updateRequirement(requirement.getRequirementID(),newAssignedPTTs);

            System.out.println("The assigned PTTs for the requirement have been updated successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input format. Please try again.");
        }finally {
            scanner.close();
        }
    }

    /**
     * viewRequirements
     * 
     * Implements logic to allow the administrator to view
     * all entries in the requirement DB
     * 
     */
    public void viewRequirements() {
        List<Requirement> requirements = DatabaseManager.getInstance().getRequirements();
        if (requirements.isEmpty()) {
            System.out.println("No requirements found in the database.");
        } else {
            System.out.println("List of Requirements:");
            for (Requirement requirement : requirements) {
                System.out.println("Requirement ID: " + requirement.getRequirementID());
                System.out.println("Course Details: " + requirement.getCourseDetail());
                System.out.println("Required Number of PTTs: " + requirement.getRequiredNumberOfPTTs());
                System.out.println("Required Trainings: " + requirement.getRequiredTrainings());
                System.out.println("Assigned PTTs: " + requirement.getAssignedPTTs());
                System.out.println("----------------------------------------");
            }
        }
    }

    /**
     * viewPartTimeTeachersData
     * 
     * Implements logic to allow the administrator to view
     * all entries in the Teachers DB
     * 
     */
    public void viewPartTimeTeachersData() {
        List<Teacher> teachers = DatabaseManager.getInstance().getPartTimeTeachers();
        if (teachers.isEmpty()) {
            System.out.println("No part-time teachers found in the database.");
        } else {
            System.out.println("List of Part-time Teachers:");
            for (Teacher teacher : teachers) {
                System.out.println("Staff ID: " + teacher.getStaffID());
                System.out.println("Name: " + teacher.getStaffName());
                System.out.println("Expertise: " + teacher.getExpertise());
                System.out.println("Availability: " + teacher.getAvailability());
                System.out.println("Assigned Trainings: " + teacher.getAssignedTrainings());
                System.out.println("----------------------------------------");
            }
        }
    }

    /**
     * viewPartTimeTeacherData
     * 
     * Implements logic to allow the administrator to view
     * all entries in the requirement DB
     * 
     */
    public void viewPartTimeTeacherData(int staffID) {
        List<Teacher> teachers = DatabaseManager.getInstance().getPartTimeTeachers();
        boolean found = false;
        for (Teacher teacher : teachers) {
            if (teacher.getStaffID() == staffID) {
                found = true;
                System.out.println("Teacher Details:");
                System.out.println("Staff ID: " + teacher.getStaffID());
                System.out.println("Name: " + teacher.getStaffName());
                System.out.println("Expertise: " + teacher.getExpertise());
                System.out.println("Availability: " + teacher.getAvailability());
                System.out.println("Assigned Trainings: " + teacher.getAssignedTrainings());
                break;
            }
        }
        if (!found) {
            System.out.println("No part-time teacher found with the provided staff ID.");
        }
         }

    /**
     * viewRequirements
     * 
     * Implements logic to allow the administrator to view
     * all entries in the requirement DB
     * 
     */
    public void viewRequirement(int reqID) {
        List<Requirement> requirements = DatabaseManager.getInstance().getRequirements();
        boolean found = false;
        for (Requirement requirement : requirements) {
            if (requirement.getRequirementID() == reqID) {
                found = true;
                System.out.println("Requirement Details:");
                System.out.println("Requirement ID: " + requirement.getRequirementID());
                System.out.println("Course Details: " + requirement.getCourseDetail());
                System.out.println("Required Number of PTTs: " + requirement.getRequiredNumberOfPTTs());
                System.out.println("Required Trainings: " + requirement.getRequiredTrainings());
                System.out.println("Assigned PTTs: " + requirement.getAssignedPTTs());
                break;
            }
        }
        if (!found) {
            System.out.println("No requirement found with the provided ID.");
        }
    }

}
