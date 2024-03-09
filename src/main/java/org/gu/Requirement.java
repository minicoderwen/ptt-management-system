package org.gu;

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
    private String assignedPTTs;

    public Requirement(int reqID, Course courseDetail, int requiredNumberOfPTTs, String requiredTrainings,
            String assignedPTTs) {

        // Requirements can be automated too
        // But when I read from file I do not want this,
        // I want to keep the reqID as it is in the file
        // ReqID will not be necessarily in order, hence not having it automated
        // Make sure to have validation in DB manager to check if the reqID is already
        // present in which case do not allow the req to be added.

        this.setRequirementID(reqID);
        this.setCourseDetail(courseDetail);
        this.setRequiredNumberOfPTTs(requiredNumberOfPTTs);
        this.setRequiredTrainings(requiredTrainings);
        this.setAssignedPTTs(assignedPTTs);
    }

    public int getRequirementID() {
        return reqID;
    }

    public void setRequirementID(int id) {
        this.reqID = id;
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
        this.requiredNumberOfPTTs = requiredNumberOfPTTs;
    }

    public String getRequiredTrainings() {
        return requiredTrainings;
    }

    public void setRequiredTrainings(String requiredTrainings) {
        this.requiredTrainings = requiredTrainings;
    }

    public String getAssignedPTTs() {
        return assignedPTTs;
    }

    public void setAssignedPTTs(String assignedPTTs) {
        this.assignedPTTs = assignedPTTs;
    }

}
