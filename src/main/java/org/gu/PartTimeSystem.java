package org.gu;

/**
 * PartTimeSystem.java
 * 
 * PartTimeSystem class is the main class that allows class director to
 * input his request, and the administrator to review and fill the requirements
 * registered
 * 
 */

public class PartTimeSystem {

    private static DatabaseManager databaseManager;

    /**
     * Runs the system
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Start System
        // Login
        // Present menu based on the selection
        // Stop System when user exit
    }

    /**
     * 
     * Allows the user to login in the system either as
     * administrator or class director to get permissible
     * functionalities
     * 
     */
    public void login() {
        System.out.println("Welcome to the Part-time teachers Management System");
        System.out.println("Login as Class Director(1), Administrator(2) or Exit(3), Enter you choice:");
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
     * 
     */
    public void classDirectorMenu() {
        System.out.println("Enter your name and ID:");
        // 1. Take input

        // 2. Instantiate ClassDirector with the given inputs to be able to use the
        // methods

        // If needed we can keep a list of allowable IDs that can login as class
        // Director/ Admin. Now just take in the name and ID and give a welcome message
        System.out.println("Welcome Class Director"); // Can improve

        // Mostly need to take inputs from console and then call appropriate
        // method in ClassDirector class to implement the functionality

        // 3. Present next set of options - add any methods as needed for clean coding
        // (1) ADD
        // (2) DELETE
        // (3) VIEW
        // (4) EDIT
        // (5) BACK TO MAIN MENU - login()
        // (6) EXIT - endSystem()
    }

    /**
     * Present user with the functionalities the administrator
     * can access in the system
     * 
     */
    public void administratorMenu() {
        System.out.println("Enter your name and ID:");
        // 1. Take input

        // 2. Instantiate Administrator with the given inputs to be able to use the
        // methods

        // If needed we can keep a list of allowable IDs that can login as class
        // Director/ Admin. Now just take in the name and ID and give a welcome message
        System.out.println("Welcome Administrator"); // Can improve

        // Mostly need to take inputs from console and then call appropriate
        // method in Administrator class to implement the functionality

        // 3. Present next set of options - add any methods as needed for clean coding
        // (1) VIEW
        // (2) EDIT
        // (3) BACK TO MAIN MENU - login()
        // (4) EXIT - endSystem()
    }

    /**
     * 
     */
    public void startSystem() {
        // Read all data from the databases (File)
    }

    /**
     * 
     */
    public void stopSystem() {
        // Writes the data back to the database (File)

    }
}
