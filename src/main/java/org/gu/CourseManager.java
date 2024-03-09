package org.gu;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * CourseManager.java
 * 
 * CourseManager class manages the list of courses offerred in the university
 * 
 */
public class CourseManager {

    private static CourseManager courseManager;
    private Set<Course> courseSet;

    /**
     * Constructor
     */
    private CourseManager() {
        this.courseSet = new HashSet<>();
        loadCourses();
    }

    /**
     * getInstance()
     * 
     * @return CourseManager
     */
    public static CourseManager getInstance() {
        if (courseManager == null) {
            courseManager = new CourseManager();
        }
        return courseManager;
    }

    /**
     * 
     * Populates the course set
     * 
     */
    private void loadCourses() {
        // Decide if you want to have as local method or something in a file that is
        // read and used to populated the set

        // Start with local function that reads a lines of string and then if needed we
        // can push to a file
    }

    /**
     * 
     * @return Set<course>
     */
    public Set<Course> getCourses() {
        return this.courseSet;
    }

    /**
     * 
     * viewOfferredCourses
     * 
     */
    public void viewOfferredCourses() {
        // Prints the list of courses
        // Format the list of course for printing
    }
}
