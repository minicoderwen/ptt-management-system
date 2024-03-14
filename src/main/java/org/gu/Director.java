package org.gu;

import java.util.Scanner;

import org.contract.*;

/**
 * 
 * Director.java
 * 
 * Director class represents the class director in the university,
 * responsible for adding teaching requirements which can be reviewed by the 
 * administrator and fulfilled.
 * 
 * Implements the Add, View, Delete and Edit interfaces, allowing CRUD operations
 * on the Requirements lists and read Part-time teachers list
 * 
 */

public class Director extends Staff implements Add, Edit, Delete {

	public Director(int id, String name) {
		super(id, name);
	}

	@Override
	/**
	 * Take input from user and add requirements to the database
	 * 
	 * @param scanner(Scanner)
	 */
	public void addRequirements(Scanner scanner) {
		try {
			System.out.println("Please enter the requirement in the format: REQID, COURSEID, REQUIRED_TRAINING, NUMBER_OF_PTTS");
			String userInput = scanner.nextLine();

			String[] data = userInput.split(",");

			if (data.length > 4) {
				throw new IllegalArgumentException("Invalid input format. Please provide the requirement in the specified format");
			}

			int reqID = Integer.parseInt(data[0]);
			String courseID = data[1];
			String requiredTraining = data[2];
			int numberOfPTTs = Integer.parseInt(data[3]);

			// Check if requirement ID already exists
			if (DatabaseManager.getInstance().requirementExists(reqID)) {
				throw new IllegalArgumentException("Requirement with ID " + reqID + " already exists.");
			}

			// Retrieve other details from course database based on course ID (Assuming it exists)
			Course course = DatabaseManager.getInstance().getCourse(courseID);

			// If the course does not exist in the database, throw an error
			if (course == null) {
				throw new IllegalArgumentException("Course with ID " + courseID + " does not exist.");
			}

			// Construct the string to add the requirement
			String toAddRequirement = reqID + "," + courseID + "," + course.getCourseName() + "," + requiredTraining + "," + numberOfPTTs;

			// Add the requirement to the database
			DatabaseManager.getInstance().addRequirement(toAddRequirement);
			System.out.print("The requirement has been added successfully!");
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("An error occurred while adding the requirement. Please try again.");
			e.printStackTrace();
		}
	}


	@Override
	/**
	 *  deleteRequirement
	 *  @param reqID
	 */
	public void deleteRequirements(int reqID) {
		DatabaseManager.getInstance().deleteRequirement(reqID);
	}

	@Override
	/***
	 *  editRequirement
	 *  @param reqID
	 */
	public void editRequirement(Scanner scanner, int reqID) {
		try {
			// Check if requirement ID already exists
			if (!DatabaseManager.getInstance().requirementExists(reqID)) {
				throw new IllegalArgumentException("Requirement ID "+ reqID +" not found");
			}

			System.out.println("Please enter the updated details in the format REQUIRED_TRAINING, NUMBER_OF_PTTS ");
			String newRequirement = scanner.nextLine();

			String[] data = newRequirement.split(",");

			if (data.length > 2) {
				throw new IllegalArgumentException("Invalid input format. Please provide the requirement in the specified format");
			}

			String requiredTraining = data[0];
			int numberOfPTTs = Integer.parseInt(data[1]);

			Requirement newReq = DatabaseManager.getInstance().getRequirement(reqID);
			newReq.setRequiredTrainings(requiredTraining);
			newReq.setRequiredNumberOfPTTs(numberOfPTTs);

			DatabaseManager.getInstance().updateRequirement(newReq);
			System.out.println("The data has been updated successfully!");		
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("An error occurred while adding the requirement. Please try again.");
			e.printStackTrace();
		}
	}
}
