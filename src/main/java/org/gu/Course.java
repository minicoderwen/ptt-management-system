package org.gu;

/**
 * 
 * Course.java
 * 
 * This class represents a course offered in the university characterized by
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

    public Course(String courseID, String courseName) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.setRequiredExpertise("");
    }

    // Getters and Setters
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRequiredExpertise() {
        return requiredExpertise;
    }

    public void setRequiredExpertise(String requiredExpertise) {
        this.requiredExpertise = requiredExpertise;
    }
    
    /**
     * @return String
     */
    public String toString() {
    	return String.format("%-5s %-35s %s", courseID, courseName, requiredExpertise);
    }

}
