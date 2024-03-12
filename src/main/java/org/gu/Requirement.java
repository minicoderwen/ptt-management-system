package org.gu;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Requirement.java
 * 
 * Requirement class represents the part-time teaching requirement
 * added by the class-director and it is characterised by a requirement ID,
 * course details, Number of Part-time teachers required, Required trainings
 * and assigned Part-time teachers for this request.
 * 
 * 
 */
public class Requirement {
    private int reqID;
    private Course courseDetail;
    private int requiredNumberOfPTTs;
    private String requiredTrainings;
    private List<String> assignedPTTs; // Assuming teacher names for simplicity

    /**
     * Constructs a Requirement object with initial values for its properties.
     *
     * @param reqID                The unique identifier for the requirement.
     * @param courseDetail         The details of the course associated with this requirement.
     * @param requiredNumberOfPTTs The number of part-time teachers required.
     * @param requiredTrainings    The trainings required for the part-time teachers.
     * @param assignedPTTs         The list of names of the assigned part-time teachers.
     */
    public Requirement(int reqID, Course courseDetail, int requiredNumberOfPTTs,
                       String requiredTrainings, List<String> assignedPTTs) {
        this.reqID = reqID;
        this.courseDetail = courseDetail;
        this.requiredNumberOfPTTs = validateRequiredNumberOfPTTs(requiredNumberOfPTTs);
        this.requiredTrainings = requiredTrainings;
        this.assignedPTTs = new ArrayList<>(assignedPTTs); // Allows for modification
    }

    private int validateRequiredNumberOfPTTs(int requiredNumberOfPTTs) {
        if (requiredNumberOfPTTs < 0) {
            throw new IllegalArgumentException("Number of part-time teachers must be non-negative.");
        }
        return requiredNumberOfPTTs;
    }

    public int getRequirementID() {
        return reqID;
    }

    public void setRequirementID(int reqID) {
        this.reqID = reqID;
    }

    public Course getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(Course courseDetail) {
        this.courseDetail = courseDetail;
    }

    public int getRequiredNumberOfPTTs() {
        return requiredNumberOfPTTs;
    }

    public void setRequiredNumberOfPTTs(int requiredNumberOfPTTs) {
        this.requiredNumberOfPTTs = validateRequiredNumberOfPTTs(requiredNumberOfPTTs);
    }

    public String getRequiredTrainings() {
        return requiredTrainings;
    }

    public void setRequiredTrainings(String requiredTrainings) {
        this.requiredTrainings = requiredTrainings;
    }

    public List<String> getAssignedPTTs() {
        return assignedPTTs;
    }

    public void setAssignedPTTs(List<String> assignedPTTs) {
        this.assignedPTTs = new ArrayList<>(assignedPTTs);
    }

    /**
     * This method was modified to accept a List<String> instead of a single String to better
     * represent multiple part-time teachers. If you need to maintain the original String-based
     * approach for compatibility, you'll need to adapt the handling of assignedPTTs accordingly.
     */

    @Override
    public String toString() {
        return "Requirement{" +
                "reqID=" + reqID +
                ", courseDetail=" + courseDetail +
                ", requiredNumberOfPTTs=" + requiredNumberOfPTTs +
                ", requiredTrainings='" + requiredTrainings + '\'' +
                ", assignedPTTs=" + assignedPTTs +
                '}';
    }
}
