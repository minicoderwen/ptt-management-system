package org.gu;

import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseManager.java
 * 
 * DatabaseManager manages the requirements and teachers list
 * 
 * 
 */
public class DatabaseManager {

    private static DatabaseManager dBManager;
    private List<Requirement> requirementsList;
    private List<Teacher> teachersList;

    /**
     * Constructor
     */
    private DatabaseManager() {
        this.requirementsList = new ArrayList<>();
        this.teachersList = new ArrayList<>();
        loadRequirements();
        loadTeachers();
        // CourseManager.getInstance(); // This loads courses
    }

    /**
     * getInstance()
     * 
     * @return DatabaseManager
     */
    public static DatabaseManager getInstance() {
        if (dBManager == null) {
            dBManager = new DatabaseManager();
        }
        return dBManager;
    }

    /**
     * 
     * loadRequirements()
     * 
     */
    private void loadRequirements() {
        // Reads requirements file and populates the list requirementsList

        // Fields in the File are comma separated values
        // REQID,COURSE_ID,COURSE_NAME,REQUIRED_TRAININGS(space
        // separated),Number_of_PTTs,Assigned_PTTs(space separated)
        // Eg: 1,20,COMPSCI,Java C++,2,42 10

    }

    /**
     * 
     * loadTeachers()
     * 
     */
    private void loadTeachers() {
        // Reads Teachers file and populates the list teachersList

        // Fields in the File should be comma separated values
        // STAFF_ID,STAFF_NAME,EXPERTISE,AVAILABILITY, TRAININGS(space separated)
        // Eg: 42,Emily,Java,0,
        // 10,Remo,C++,1,Fundamentals of C++

    }

    /**
     * getRequirements()
     * 
     * @return List<Requirement>
     */
    public List<Requirement> getRequirements() {
        return this.requirementsList;
    }

    /**
     * getPartTimeTeachers()
     * 
     * @return List<Teacher>
     */
    public List<Teacher> getPartTimeTeachers() {
        return this.teachersList;
    }

    /**
     * Given a reqID return the requested requirement's
     * details
     * 
     * @param reqID (int)
     * @return Requirements
     * 
     * 
     */
    public Requirement getRequirement(int reqID) {
        // TO DO
        return null;
    }

    /**
     * Given a staffID return the requested teacher's
     * details
     * 
     * @param pttID (int)
     * @return Teacher
     */
    public List<Teacher> getPartTimeTeachers(int pttID) {
        // TO DO
        return null;
    }

    /**
     * Given a reqDetail add it to the requirement list
     * 
     * @param reqDetail
     */
    public void addRequirement(String reqDetail) {

    }

    /**
     * Given a reqID delete the corresponding requirement
     * 
     * @param reqID
     */
    public void deleteRequirement(int reqID) {

    }

    /**
     * Given a reqID, and to update data update the respective reqID with
     * the new detail
     * 
     * @param reqID
     * @param toUpdateReq
     */
    public void updateRequirement(int reqID, String toUpdateReq) {

    }

    /**
     * 
     * Given a staffID and to update data update the respective staff with
     * the new detail
     * 
     * @param staffID
     * @param toUpdateDetail
     */
    public void updateTeacher(int staffID, String toUpdateDetail) {
        // Make sure to use the updateTrainingDetails in Teacher -
        // to make sure availability is updated automatically
    }
}
