package org.gu;

import org.contract.Add;
import org.contract.Delete;
import org.contract.Edit;

import java.util.Scanner;

/**
 * PartTimeSystem.java
 * <p>
 * PartTimeSystem class is the main class that allows class director to
 * input his request, and the administrator to review and fill the requirements
 * registered
 */

public class PartTimeSystem {

    private static DatabaseManager databaseManager;
    Scanner scanner;

    private PartTimeSystem() {
        databaseManager = DatabaseManager.getInstance();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the system
     */
    public static void main(String[] args) {
        // Start System
        // Login
        // Present menu based on the selection
        // Stop System when user exit
        PartTimeSystem partTimeSystem = new PartTimeSystem();
        partTimeSystem.startSystem();
    }

    /**
     * Allows the user to login in the system either as
     * administrator or class director to get permissible
     * functionalities
     */
    public void login() {
        System.out.println("Welcome to the Part-time teachers Management System");
        System.out.println("Login as Class Director(1), Administrator(2) or Exit(3), Enter you choice:");

        verifyInteger("That's not a valid choice. Please enter a number between 1 and 6:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                SimplePair directorPair = loginVerify();
                System.out.println("Welcome Class Director " + directorPair.getName());
                classDirectorMenu(new Director(directorPair.getId(), directorPair.getName()));
            }
            case 2 -> {
                SimplePair adminPair = loginVerify();
                System.out.println("Welcome Class Administrator " + adminPair.getName());
                administratorMenu(new Administrator(adminPair.getId(), adminPair.getName()));
            }
            case 3 -> stopSystem();
            default -> {
                System.out.println("Invalid choice, please enter 1, 2, or 3");
                login();
            }
        }
        // 1. Take input from user
        // 2. Based on the user's selection call the appropriate function for further
        // interaction
        // (1) Class Director - classDirectorMenu()
        // (2) Administrator - administratorMenu()
        // (3) Exit - endSystem()
    }

    /**
     * Present user with the functionalities the class director
     * can access in the system
     */
    public void classDirectorMenu(Director director) {

        // If needed we can keep a list of allowable IDs that can login as class
        // Director/ Admin. Now just take in the name and ID and give a welcome message

        // Mostly need to take inputs from console and then call appropriate
        // method in ClassDirector class to implement the functionality

        // 3. Present next set of options - add any methods as needed for clean coding
        // (1) ADD
        // (2) DELETE
        // (3) VIEW
        // (4) EDIT
        // (5) BACK TO MAIN MENU - login()
        // (6) EXIT - endSystem()

        System.out.println("\nAvailable Actions:");
        System.out.println("(1) ADD\n(2) DELETE\n(3) VIEW\n(4) EDIT\n(5) BACK TO MAIN MENU\n(6) EXIT");
        System.out.println("Enter your choice:");

        verifyInteger("That's not a valid choice. Please enter a number between 1 and 6:");

        int action = scanner.nextInt();
        switch (action) {
            case 1 -> {
                addRequirementFunction(director);
                classDirectorMenu(director);
            }
            case 2 -> {
                deleteRequirementFunction(director);
                classDirectorMenu(director);
            }
            case 3 -> {
                director.viewRequirements();
                classDirectorMenu(director);
            }
            case 4 -> editRequirementFunction(director);
            case 5 -> login(); // Return to the main menu
            case 6 -> stopSystem(); // Exit the application
            default -> {
                System.out.println("Invalid choice, please enter a valid option.");
                classDirectorMenu(director);
            }
        }
    }


    private void addRequirementFunction(Add adder) {
        System.out.println("Please enter your requirement detail: ");
        String req = scanner.next();
        adder.addRequirements(req);
        System.out.println("Add successfully!");
    }


    private void deleteRequirementFunction(Delete deleter) {
        System.out.println("Please enter the requirement ID you wish to delete: ");

        verifyInteger("Invalid input. Please enter a numeric ID: ");
        int deleteReqID = scanner.nextInt();

        // Verify if the requirement ID exists.
        if (databaseManager.requirementExists(deleteReqID)) {
            deleter.deleteRequirements(deleteReqID);
            System.out.println("Delete successfully!");
        } else {
            System.out.println("No requirement found with ID: " + deleteReqID + ". Please try again.");
        }
    }

    private void editRequirementFunction(Edit editor) {
        System.out.println("Please enter the requirement ID you wish to edit: ");

        // Ensure the input is an integer.
        verifyInteger("Invalid input. Please enter a numeric ID: ");
        int editReqID = scanner.nextInt();

        // Verify if the requirement ID exists.
        if (databaseManager.requirementExists(editReqID)) {
            editor.editRequirement(editReqID);
            System.out.println("Edit successfully!");
        } else {
            System.out.println("No requirement found with ID: " + editReqID + ". Please try again.");
        }
    }


    /**
     * Present user with the functionalities the administrator
     * can access in the system
     */
    public void administratorMenu(Administrator administrator) {
        System.out.println("\nAvailable Actions:");
        System.out.println("\n(1) VIEW\n(2) EDIT\n(3) BACK TO MAIN MENU\n(4) EXIT");
        System.out.println("Enter your choice:");
        verifyInteger("That's not a valid choice. Please enter a number between 1 and 4:");
        int action = scanner.nextInt();

        switch (action) {
            case 1:
                administrator.viewRequirements();
                administratorMenu(administrator);
            case 2:
                editRequirementFunction(administrator);
                administratorMenu(administrator);
            case 3:
                login();
            case 4:
                stopSystem();
            default: {
                System.out.println("Invalid choice, please enter a valid option.");
                administratorMenu(administrator);
            }
        }
    }


    /**
     *
     */
    public void startSystem() {
        // Read all data from the databases (File)
        login();
    }

    /**
     *
     */
    public static void stopSystem() {


        // Writes the data back to the database (File)

    }

    private SimplePair loginVerify() {
        System.out.println("Enter your name:");
        String name = scanner.next();
        // Verification for name (simple example: ensure it's not empty)
        while (name.trim().isEmpty()) {
            System.out.println("Invalid name. Please enter a non-empty name:");
            name = scanner.next();
        }

        System.out.println("Enter your ID:");
        // Ensure the input is an integer
        verifyInteger("Invalid ID. Please enter a numeric ID:");
        int ID = scanner.nextInt();
        // Verification for ID (example: ensure it's positive)
        while (ID <= 0) {
            System.out.println("Invalid ID. Please enter a positive ID:");
            verifyInteger("Invalid ID. Please enter a numeric ID:");
            ID = scanner.nextInt();
        }

        return new SimplePair(ID, name);
    }

    private void verifyInteger(String failurePrompt) {
        while (!scanner.hasNextInt()) {
            System.out.println(failurePrompt);
            scanner.next();
        }
    }

    private class SimplePair {
        private String name;
        private int id;

        public SimplePair(int id, String name) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

}
