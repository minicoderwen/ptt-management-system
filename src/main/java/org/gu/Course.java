package org.gu;

/**
 * 
 * Course.java
 * 
 * This class represents a course offerred in the university characteristied by
 * courseID, courseName and expertise required for the course.
 * 
 */
public class Course {
    private String courseID;
    private String courseName;
    private String requiredExpertise;

    /**
     * Constructor
     * 
     * @param courseID
     * @param courseName
     * @param requiredExpertise
     */
    public Course(String courseID, String courseName, String requiredExpertise) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.setRequiredExpertise(requiredExpertise);
    }

    // Getters and Setters
    public String getCourseID() {
        return courseID;
    }

    private void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    private void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRequiredExpertise() {
        return requiredExpertise;
    }

    private void setRequiredExpertise(String requiredExpertise) {
        this.requiredExpertise = requiredExpertise;
    }

}
