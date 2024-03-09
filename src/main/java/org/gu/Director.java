package org.gu;

import org.contract.*;

public class Director extends Staff implements Add, View, Edit, Delete {

    public Director(int id, String name) {
        super(id, name);
    }

    @Override
    public void addRequirements(String req) {
        // TO DO
    }

    @Override
    public void deleteRequirements(int reqID) {
        // TO DO
    }

    @Override
    public void editRequirement(int reqID) {
        // TO DO
    }

    @Override
    public void editPartTimeTeacherData(int staffID) {
        // TO DO
    }

    @Override
    public void viewRequirements() {
        // TO DO
    }

    @Override
    public void viewPartTimeTeachersData() {
        // TO DO
    }

    @Override
    public void viewRequirement(int reqID) {
        // TO DO
    }

    @Override
    public void viewPartTimeTeacherData(int staffID) {
        // TO DO
    }

    // View Course List
    void viewCourseList() {
        // Invoke courseManager's viewOfferredCourses to view the list of courses
    }
}
