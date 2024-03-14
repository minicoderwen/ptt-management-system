package org.gu;

import org.contract.*;

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
        // Loads data from database
        databaseManager = DatabaseManager.getInstance();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the system
     */
    public static void main(String[] args) {
        PartTimeSystem partTimeSystem = new PartTimeSystem();
        partTimeSystem.startSystem();
    }

    /**
     * Start system
     */
    public void startSystem() {
        login();
    }

    /**
     * Stop system
     * Save all changes to the database
     */
    public static void stopSystem() {
        System.out.println("Exiting System. Changes made have been saved");
        // databaseManager.saveRequirements();
        // databaseManager.savePartTimeTeachers();
    }

    /**
     * Allows the user to login in the system either as
     * administrator or class director to get permissible
     * functionalities
     */
    public void login() {
        // (1) Class Director - classDirectorMenu()
        // (2) Administrator - administratorMenu()
        // (3) Exit - endSystem()
        System.out.println("WELCOME TO THE PART-TIME TEACHERS MANAGEMENT SYSTEM\n");
        System.out.println("Login as\n(1) Class Director\n(2) Administrator \n(3) Exit\n\nEnter you choice:");

        verifyChoice("That's not a valid choice. Please enter a number between 1 and 3:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                SimplePair directorPair = verifyLogin();
                System.out.println("Welcome Class Director " + directorPair.getName());
                classDirectorMenu(new Director(directorPair.getId(), directorPair.getName()));
            }
            case 2 -> {
                SimplePair adminPair = verifyLogin();
                System.out.println("Welcome Class Administrator " + adminPair.getName());
                administratorMenu(new Administrator(adminPair.getId(), adminPair.getName()));
            }
            case 3 -> stopSystem();
            default -> {
                System.out.println("Invalid choice, please enter 1, 2, or 3");
                login();
            }
        }
    }

    /**
     * Present user with the functionalities the class director
     * can access in the system
     *
     * @param director (Director)
     */
    public void classDirectorMenu(Director director) {
        // (1) ADD
        // (2) DELETE
        // (3) VIEW
        // (4) EDIT
        // (5) BACK TO MAIN MENU - login()
        // (6) EXIT - endSystem()
        System.out.println("\nAvailable Actions:");
        System.out.println("(1) ADD\n(2) DELETE\n(3) VIEW\n(4) EDIT\n(5) BACK TO MAIN MENU\n(6) EXIT");
        System.out.println("Enter your choice:");

        verifyChoice("That's not a valid choice. Please enter a number between 1 and 6:");

        int action = scanner.nextInt();
        scanner.nextLine();
        switch (action) {
            case 1 -> {
                addRequirement(director);
                classDirectorMenu(director);
            }
            case 2 -> {
                deleteRequirement(director);
                classDirectorMenu(director);
            }
            case 3 -> {
                viewMenu(director);
            }
            case 4 -> {
                editRequirement(director);
                classDirectorMenu(director);
            }
            case 5 -> login(); // Return to the main menu
            case 6 -> stopSystem(); // Exit the application
            default -> {
                System.out.println("Invalid choice, please enter a valid option.");
                classDirectorMenu(director);
            }
        }
    }

    /**
     * Present user with the functionalities the administrator
     * can access in the system
     *
     * @param administrator (Administrator)
     */
    public void administratorMenu(Administrator administrator) {
        // (1) VIEW
        // (2) EDIT
        // (3) BACK TO MAIN MENU - login()
        // (4) EXIT - endSystem()
        System.out.println("\nAvailable Actions:");
        System.out.println("\n(1) VIEW\n(2) EDIT\n(3) BACK TO MAIN MENU\n(4) EXIT");
        System.out.println("Enter your choice:");
        verifyChoice("That's not a valid choice. Please enter a number between 1 and 4:");
        int action = scanner.nextInt();
        scanner.nextLine();
        switch (action) {
            case 1:
                viewMenu(administrator);
                break;
            case 2:
                editMenu(administrator);
                break;
            case 3:
                login();
                break;
            case 4:
                stopSystem();
                break;
            default:
                System.out.println("Invalid choice, please enter a valid option.");
                administratorMenu(administrator);
        }
    }

    /*
     *  Helper methods
     *
     */
    private void addRequirement(Add adder) {
        adder.addRequirements(scanner);
    }


    private void deleteRequirement(Delete deleter) {
        System.out.println("Please enter the requirement ID you wish to delete: ");

        verifyChoice("Invalid input. Please enter a numeric ID: ");
        int deleteReqID = scanner.nextInt();
        scanner.nextLine();
        // Verify if the requirement ID exists.
        if (databaseManager.requirementExists(deleteReqID)) {
            deleter.deleteRequirements(deleteReqID);
            System.out.println("Delete successfully!");
        } else {
            System.out.println("No requirement found with ID: " + deleteReqID + ". Please try again.");
        }
    }

    private void editMenu(Administrator admin) {
        System.out.println("\nAvailable Actions:");
        System.out.println("\n(1) EDIT REQUIREMENTS\n(2) EDIT TEACHERS\n(3) EXIT");
        System.out.println("Enter your choice:");
        verifyChoice("That's not a valid choice. Please enter a number between 1 and 3:");
        int action = scanner.nextInt();
        scanner.nextLine();
        switch (action) {
            case 1:
                editRequirement(admin);
                administratorMenu(admin);
                break;
            case 2:
                editTeacher(admin);
                administratorMenu(admin);
                break;
            case 3:
                stopSystem();
                break;
            default:
                System.out.println("Invalid choice, please enter a valid option.");
        }
    }

    private void viewMenu(Staff viewer) {
        System.out.println("\nAvailable Actions:");
        System.out.println("\n(1) VIEW REQUIREMENTS\n(2) VIEW TEACHERS\n(3) VIEW COURSES\n(4) BACK TO MAIN MENU\n(5) EXIT");
        System.out.println("Enter your choice:");
        verifyChoice("That's not a valid choice. Please enter a number between 1 and 4:");
        int action = scanner.nextInt();
        scanner.nextLine();
        switch (action) {
            case 1:
                databaseManager.viewRequirements();
                invokeMenu(viewer);
                break;
            case 2:
                databaseManager.viewPartTimeTeachersData();
                invokeMenu(viewer);
                break;
            case 3:
                databaseManager.viewOfferredCourses();
                invokeMenu(viewer);
                break;
            case 4:
                login();
                break;
            case 5:
                stopSystem();
                break;
            default:
                System.out.println("Invalid choice, please enter a valid option.");
        }
    }

    private void editRequirement(Edit editor) {
        System.out.println("Please enter the requirement ID you wish to edit: ");

        // Ensure the input is an integer.
        verifyChoice("Invalid input. Please enter a numeric ID: ");
        int editReqID = scanner.nextInt();
        scanner.nextLine();
        // Verify if the requirement ID exists.
        if (databaseManager.requirementExists(editReqID)) {
            editor.editRequirement(scanner, editReqID);
            System.out.println("Edited successfully!");
        } else {
            System.out.println("No requirement found with ID: " + editReqID + ". Please try again.");
        }
    }

    private void editTeacher(Administrator admin) {
        System.out.println("Please enter the staff ID you wish to update: ");
        // Ensure the input is an integer.
        verifyChoice("Invalid input. Please enter a numeric ID: ");
        int editStaffID = scanner.nextInt();
        scanner.nextLine();
        // Verify if the requirement ID exists.
        if (databaseManager.teacherExists(editStaffID)) {
            admin.editPartTimeTeacherData(scanner, editStaffID);
            System.out.println("Edited successfully!");
        } else {
            System.out.println("No teacher found with ID: " + editStaffID + ". Please try again.");
        }
    }

    private SimplePair verifyLogin() {
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        // Verification for name (simple example: ensure it's not empty)
        while (name.trim().isEmpty()) {
            System.out.println("Invalid name. Please enter a non-empty name:");
            name = scanner.nextLine();
        }

        System.out.println("Enter your ID:");
        // Ensure the input is an integer
        verifyChoice("Invalid ID. Please enter a numeric ID:");
        int ID = scanner.nextInt();
        scanner.nextLine();
        // Verification for ID (example: ensure it's positive)
        while (ID <= 0) {
            System.out.println("Invalid ID. Please enter a positive ID:");
            verifyChoice("Invalid ID. Please enter a numeric ID:");
            ID = scanner.nextInt();
            scanner.nextLine();
        }

        return new SimplePair(ID, name);
    }


    private void invokeMenu(Staff viewer) {
        if (viewer instanceof Director) {
            classDirectorMenu((Director) viewer);
        } else {
            administratorMenu((Administrator) viewer);
        }

    }

    private void verifyChoice(String failurePrompt) {
        if (!scanner.hasNextInt()) {
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