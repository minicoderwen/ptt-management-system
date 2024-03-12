package org.gu;

/**
 *
 * Teacher.java
 *
 * Teacher class represents the part-time teacher in the university
 *
 */

public class Teacher extends Staff {

    private String expertise;
    private String assignedTrainings;
    private boolean isAvailable;

    /**
     * Constructor
     *
     * @param id
     * @param name
     */
    public Teacher(int id, String name) {
        super(id, name);
    }

    // Constructor overload
    public Teacher(int id, String name, String expertise) {
        super(id, name);
        this.setExpertise(expertise);
        this.setAvailablility(true);
        this.setAssignedTrainings(new String());
    }

    // Constructor overload
    public Teacher(int id, String name, String expertise, String trainings) {
        super(id, name);
        this.setExpertise(expertise);
        this.updateTrainingDetails(trainings);
    }

    public void updateExpertise(String expertise) {
        setExpertise(expertise);
    }

    // Getters and Setters
    private void setExpertise(String expertise) {
        if (expertise != null && !expertise.trim().isEmpty()) {
            this.expertise = expertise;
        } else {
            // Handle invalid expertise input appropriately
            throw new IllegalArgumentException("Expertise cannot be null or empty.");
        }
    }

    private void setAssignedTrainings(String assignedTrainings) {
        this.assignedTrainings = assignedTrainings;
    }

    private void setAvailablility(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getAssignedTrainings() {
        return assignedTrainings;
    }

    public boolean getAvailablility() {
        return isAvailable;
    }

    /**
     * updateTrainingDetails()
     * 
     * When training details are updated the teacher's
     * availability is updated
     * 
     * @param trainings
     */
    public void updateTrainingDetails(String trainings) {
        this.setAssignedTrainings(trainings);
        this.setAvailablility(false);
    }
}
