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
        this.setAvailability(true);
        this.setAssignedTrainings(new String());
    }

    // Constructor overload
    public Teacher(int id, String name, String expertise, String trainings) {
        super(id, name);
        this.setExpertise(expertise);
        this.updateTrainingDetails(trainings);
    }
    
    public Teacher(int id, String name, String expertise, boolean availability, String trainings) {
        super(id, name);
        this.setExpertise(expertise);
        this.setAvailability(availability);
        this.setAssignedTrainings(trainings);
        
    }

    // Getters and Setters
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public void setAssignedTrainings(String assignedTrainings) {
        this.assignedTrainings = assignedTrainings;
    }

    private void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getAssignedTrainings() {
        return assignedTrainings;
    }

    public boolean getAvailability() {
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
        this.setAvailability(false);
    }
    
    /**
     * 
     * @param trainings
     * @param availability
     */
    public void updateTrainingDetails(String trainings, boolean availability) {
        this.setAssignedTrainings(trainings);
        this.setAvailability(availability);
    }
    
    /**
     *  @return 
     */
    public String toString() {
    	String availability = isAvailable? "Yes": "No";
    	return String.format("%-5s %-15s %-30s %-15s %s", this.getStaffID(), this.getStaffName(), expertise, availability, assignedTrainings);
    }
}
