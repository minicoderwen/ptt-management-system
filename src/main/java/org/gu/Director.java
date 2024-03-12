package org.gu;

import org.contract.*;

import java.util.Arrays;
import java.util.List;

public class Director extends Staff implements Add, View, Edit, Delete {

    private final DatabaseManager databaseManager;

    public Director(int id, String name) {
        super(id, name);
        this.databaseManager = DatabaseManager.getInstance();
    }

    @Override
    public void addRequirements(String req) {
        // Parse the input string to extract Requirement details
        String[] parts = req.split(",");
        int reqID = Integer.parseInt(parts[0]);
        Course courseDetail = new Course(parts[1], parts[2], parts[3]);
        int requiredNumberOfPTTs = Integer.parseInt(parts[4]);
        String requiredTrainings = parts[5];
        List<String> assignedPTTs = Arrays.asList(parts[6].split("\\|")); // Assuming '|' as the delimiter for multiple PTTs

        // Creating a new requirement object with the provided details
        Requirement newRequirement = new Requirement(reqID, courseDetail, requiredNumberOfPTTs, requiredTrainings, assignedPTTs);

        // Adding the new requirement to the database
        databaseManager.addRequirement(String.valueOf(newRequirement));
    }

    @Override
    public void deleteRequirements(int reqID) {
        databaseManager.deleteRequirement(reqID);
    }

    @Override
    public void editRequirement(int reqID) {
        Requirement toUpdateReq = databaseManager.getRequirement(reqID);
        if (toUpdateReq != null) {
            toUpdateReq.setRequiredTrainings("New Training Details");
            databaseManager.updateRequirement(reqID, String.valueOf(toUpdateReq));
        }
    }

    @Override
    public void editPartTimeTeacherData(int staffID) {
        List<Teacher> teachers = databaseManager.getPartTimeTeachers();
        for (Teacher teacher : teachers) {
            if (teacher.getStaffID() == staffID) {
                try {
                    // Update the expertise directly on the Teacher object.
                    teacher.updateExpertise("Updated Expertise");

                    // Convert the update details into a string format, if necessary.
                    // This example assumes a simple string format.
                    String toUpdateDetail = "Expertise: Updated Expertise";

                    // Call the database manager to update the teacher in the database.
                    databaseManager.updateTeacher(staffID, toUpdateDetail);

                    // Optionally, log success or perform additional actions as needed.
                    System.out.println("Updated teacher with staffID " + staffID + " successfully.");

                    // Since we found the teacher and updated them, we can break out of the loop.
                    break;

                } catch (Exception e) {
                    // Handle exceptions thrown by updateExpertise.
                    // For example, log the error and/or notify the user.
                    System.err.println("Failed to update expertise for teacher with staffID " + staffID + ": " + e.getMessage());
                    // Decide whether to throw the exception, break, continue, or handle it differently.
                    break; // Here, we choose to break, stopping the operation.
                }
            }
        }
    }

    @Override
    public void viewRequirements() {
        List<Requirement> requirements = databaseManager.getRequirements();
        for (Requirement requirement : requirements) {
            System.out.println(requirement);
        }
    }

    @Override
    public void viewPartTimeTeachersData() {
        List<Teacher> teachers = databaseManager.getPartTimeTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void viewRequirement(int reqID) {
        Requirement requirement = databaseManager.getRequirement(reqID);
        if (requirement != null) {
            System.out.println(requirement);
        } else {
            System.out.println("Requirement not found for ID: " + reqID);
        }
    }

    @Override
    public void viewPartTimeTeacherData(int staffID) {
        // Retrieve the list of all part-time teachers
        List<Teacher> teachers = databaseManager.getPartTimeTeachers();
        Teacher foundTeacher = null; // Initialize foundTeacher as null

        // Loop through the list to find the teacher with the given staffID
        for (Teacher teacher : teachers) {
            if (teacher.getStaffID() == staffID) {
                foundTeacher = teacher; // Assign the found teacher to foundTeacher
                break; // Exit the loop once the teacher is found
            }
        }

        // Check if a teacher was found
        if (foundTeacher != null) {
            // Teacher found, print the teacher's information
            System.out.println(foundTeacher); // Assuming Teacher class has a meaningful toString method
        } else {
            // Teacher not found, print a message indicating so
            System.out.println("Part-time teacher not found for ID: " + staffID);
        }
    }


    public void viewCourseList() {
        CourseManager courseManager = CourseManager.getInstance();
        // Directly call the method to print offered courses.
        courseManager.viewOfferredCourses();
    }
}
