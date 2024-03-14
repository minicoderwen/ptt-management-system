package org.gu;

/**
 * Staff.java
 * 
 * Staff class represents the staffs working in the university
 * 
 */
public abstract class Staff {
    private int staffID;
    private String staffName;

    /**
     * Constructor
     * 
     * @param id   - Staff ID
     * @param name - Staff Name
     */
    public Staff(int id, String name) {
        this.staffID = id;
        this.staffName = name;
    }

    /**
     * getStaffName()
     * 
     * @return staffName (String)
     */
    public String getStaffName() {
        return this.staffName;
    }

    /**
     * 
     * getStafffID()
     * 
     * @return staffID (int)
     */
    public int getStaffID() {
        return staffID;
    }
    
    /**
     * setStaffName()
     * 
     * @return staffName (String)
     */
    public void setStaffName(String name) {
        this.staffName = name;
    }

    /**
     * 
     * setStafffID()
     * 
     * @return staffID (int)
     */
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
}
