package org.gu;

/**
 * 
 * Requirement.java
 * 
 * Requirement class represents the part-time teaching requirement
 * added by the class-director and it is characterized by a requirement ID,
 * course details, Number of Part-time teachers required, Required training,
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

    /**
     * @return String
     */
    public String toString() {
    	return String.format("%-10s %-10s %-40s %-15s %-30s %s", reqID, 
    			courseDetail.getCourseID(), courseDetail.getCourseName(), 
    			requiredNumberOfPTTs, requiredTrainings, assignedPTTs);
    }

}
