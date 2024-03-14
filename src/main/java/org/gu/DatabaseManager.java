package org.gu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.contract.*;

/**
 * DatabaseManager.java
 * <p>
 * DatabaseManager manages the requirements and teachers list
 */
public class DatabaseManager implements Load, View, Save {
    private static DatabaseManager dBManager;
    private Map<Integer, Requirement> requirements;
    private Map<Integer, Teacher> teachers;
    private Map<String, Course> courses;

    final static String REQUIREMENTS_FILENAME = "requirements.txt";
    final static String TEACHERS_FILENAME = "teachers.txt";
    final static String BASE_PATH = System.getProperty("user.dir") + File.separator + "file" + File.separator;
    final static String REQUIREMENTS_FILEPATH = BASE_PATH + REQUIREMENTS_FILENAME;
    final static String TEACHERS_FILEPATH = BASE_PATH + TEACHERS_FILENAME;

    /**
     * Constructor
     */
    private DatabaseManager() {
        this.requirements = new HashMap<>();
        this.teachers = new HashMap<>();
        this.courses = new HashMap<>();
        loadRequirements();
        loadTeachers();
        loadCourses(); // This loads courses
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
     * loadRequirements()
     */
    public void loadRequirements() {
        // Reads requirements file and populates the list requirementsList

        // Fields in the File are comma separated values
        // REQID,COURSE_ID,COURSE_NAME,REQUIRED_TRAININGS(space
        // separated),Number_of_PTTs,Assigned_PTTs(space separated)

        File reqFile = new File(REQUIREMENTS_FILEPATH);
        try (Scanner scanner = new Scanner(new FileReader(reqFile))) {
            // Check and skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // load requirements from file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int reqId = Integer.parseInt(data[0]);
                String courseId = data[1];
                String courseName = data[2];
                String requiredTrainings = data[3];
                int numberOfPTTs = Integer.parseInt(data[4]);
                String assignedPTTs = data[5];

                Course course = new Course(courseId, courseName);
                requirements.put(reqId, new Requirement(reqId, course, numberOfPTTs,
                        requiredTrainings, assignedPTTs));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * loadTeachers()
     */
    public void loadTeachers() {
        // Reads Teachers file and populates the list teachersList

        // Fields in the File should be comma separated values
        // STAFF_ID,STAFF_NAME,EXPERTISE,AVAILABILITY, TRAININGS(space separated)
        // Eg: 42,Emily,Java,0,
        // 10,Remo,C++,1,Fundamentals of C++

        File teacherFile = new File(TEACHERS_FILEPATH);
        try (Scanner scanner = new Scanner(teacherFile)) {
            // Check and skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read each line of the file and process it
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

                // Extract fields from the line
                int staffId = Integer.parseInt(fields[0]);
                String staffName = fields[1];
                String expertise = fields[2];
                boolean availability = (Integer.parseInt(fields[3]) == 1) ? true : false;
                String trainings = fields[4];

                teachers.put(staffId, new Teacher(staffId, staffName, expertise,
                        availability, trainings));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

    /**
     * loadCourses()
     */
    public void loadCourses() {
        String[] courseList = CourseManager.getCourseList().split("\n");
        for (String course : courseList) {
            String[] courseData = course.split(",");
            String courseId = courseData[0];
            String courseName = courseData[1];
            String requiredExpertise = courseData[2];
            Course newCourse = new Course(courseId, courseName, requiredExpertise);
            courses.put(courseId, newCourse);
        }
    }

    /**
     * getRequirements()
     *
     * @return Map<Integer, Requirement>
     */
    public Map<Integer, Requirement> getRequirements() {
        return this.requirements;
    }

    /**
     * getPartTimeTeachers()
     *
     * @return Map<Integer, Teacher>
     */
    public Map<Integer, Teacher> getPartTimeTeachers() {
        return this.teachers;
    }


    /**
     * @return Set<course>
     */
    public Map<String, Course> getCourses() {
        return this.courses;
    }

    /**
     * Given a reqID return the requested requirement's
     * details
     *
     * @param reqID (int)
     * @return Requirements
     */
    public Requirement getRequirement(int reqID) {
        // Iterate through the list of requirements to find the one with the matching reqID
        if (requirements.containsKey(reqID)) {
            return requirements.get(reqID);
        }
        return null;
    }

    /**
     * Given a staffID return the requested teacher's
     * details
     *
     * @param pttID (int)
     * @return Teacher
     */
    public Teacher getPartTimeTeacher(int pttID) {
        // Iterate through the list of teachers to find the one with the matching pttID
        if (teachers.containsKey(pttID)) {
            return teachers.get(pttID);

        }
        System.err.println("Teacher not found in system!");
        // Return null if no requirement with the specified reqID is found
        return null;
    }

    /**
     * @param courseID
     * @return Course
     */
    public Course getCourse(String courseID) {
        return courses.get(courseID);
    }

    /**
     * Given a reqDetail add it to the requirement list
     *
     * @param reqDetail
     */
    public void addRequirement(String reqDetail) {
        String[] data = reqDetail.split(",");
        int reqId = Integer.parseInt(data[0]);
        String courseId = data[1];
        String courseName = data[2];
        String requiredTrainings = data[3];
        int numberOfPTTs = Integer.parseInt(data[4]);
        String assignedPTTs = "";
        if (data.length > 5) {
            assignedPTTs = data[5];
        }
        Course course = new Course(courseId, courseName);
        requirements.put(reqId, new Requirement(reqId, course, numberOfPTTs, requiredTrainings, assignedPTTs));

        System.out.println("Requirement added!");
    }

    /**
     * Given a reqID delete the corresponding requirement
     *
     * @param reqID
     */
    public void deleteRequirement(int reqID) {
        if (requirements.containsKey(reqID)) {
            requirements.remove(reqID);
            System.out.println("Requirement with ID " + reqID + " deleted.");
        }
    }

    /**
     * Update the Teaching Requirement Details
     *
     * @param req
     */
    public void updateRequirement(Requirement req) {
        requirements.put(req.getRequirementID(), req);
    }

    /**
     * Update Staff Details
     *
     * @param staff
     */
    public void updateTeacher(Teacher teacher) {
        teachers.put(teacher.getStaffID(), teacher);
    }

    /**
     * @param reqID
     * @return
     */
    public boolean requirementExists(int reqID) {
        return DatabaseManager.getInstance().getRequirement(reqID) != null;
    }

    /**
     * @param staffID
     * @return
     */
    public boolean teacherExists(int staffID) {
        return DatabaseManager.getInstance().getPartTimeTeacher(staffID) != null;
    }

    @Override
    /**
     *  viewRequirements
     */
    public void viewRequirements() {
        System.out.println(String.format("%20s", "-".repeat(30) + "TEACHING REQUIREMENTS" + "-".repeat(30)));
        System.out.println(String.format("%20s", "-".repeat(120)));
        System.out.println(String.format("%-10s %-10s %-40s %-15s %-30s %s", "REQ ID", "COURSE ID",
                "COURSE NAME", "REQUIRED PTTs", "REQUIRED TRAININGS", "ASSIGNED PTTs"));
        System.out.println(String.format("%20s", "-".repeat(120)));
        for (Requirement requirement : DatabaseManager.getInstance().getRequirements().values()) {
            System.out.println(requirement);
        }
    }

    @Override
    /**
     *  viewPartTimeTeachersData
     */
    public void viewPartTimeTeachersData() {
        System.out.println(String.format("%20s", "-".repeat(30) + "PART TIME TEACHERS" + "-".repeat(30)));
        System.out.println(String.format("%20s", "-".repeat(90)));
        System.out.println(String.format("%-5s %-15s %-30s %-15s %s", "ID", "NAME", "EXPERTISE", "AVAILABILITY", "ASSIGNED TRAININGS"));
        System.out.println(String.format("%20s", "-".repeat(90)));
        for (Teacher teacher : DatabaseManager.getInstance().getPartTimeTeachers().values()) {
            System.out.println(teacher);
        }
    }

    @Override
    /**
     *  viewRequirement
     *  @param reqID
     */
    public void viewRequirement(int reqID) {
        System.out.println(DatabaseManager.getInstance().getRequirement(reqID));
    }

    @Override
    /**
     * 	viewPartTimeTeacherData
     *  @param staffID
     */
    public void viewPartTimeTeacherData(int staffID) {
        System.out.println(DatabaseManager.getInstance().getPartTimeTeacher(staffID));
    }

    /**
     * viewOfferredCourses
     */
    public void viewOfferredCourses() {
        System.out.println(String.format("%20s", "---------------COURSE LIST FOR COMING SEMESTER--------------"));
        System.out.println(String.format("%20s", "-".repeat(60)));
        System.out.println(String.format("%-5s %-35s %s", "ID", "NAME", "EXPERTISE"));
        System.out.println(String.format("%20s", "-".repeat(60)));
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    /**
     * Save the changes to the requirements list back to the file
     */
    public void saveRequirements() {
        File reqFile = new File(REQUIREMENTS_FILEPATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reqFile))) {
            // Header line
            writer.write("REQID,COURSE_ID,COURSE_NAME,REQUIRED_TRAININGS,Number_of_PTTs,Assigned_PTTs");
            writer.newLine();

            // Save the requirements
            for (Map.Entry<Integer, Requirement> entry : requirements.entrySet()) {
                Requirement requirement = entry.getValue();
                Course course = requirement.getCourseDetail();

                // String to write at each line
                String line = requirement.getRequirementID() + "," +
                        course.getCourseID() + "," +
                        course.getCourseName() + "," +
                        requirement.getRequiredTrainings() + "," +
                        requirement.getRequiredNumberOfPTTs() + "," +
                        requirement.getAssignedPTTs();

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Requirements data saved to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save the changes to the requirements list back to the file
     */
    public void savePartTimeTeachers() {
        File teacherFile = new File(TEACHERS_FILEPATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(teacherFile))) {
            // Header line
            writer.write("STAFF_ID,STAFF_NAME,EXPERTISE,AVAILABILITY,TRAININGS");
            writer.newLine();

            // Save teachers data
            for (Map.Entry<Integer, Teacher> entry : teachers.entrySet()) {
                Teacher teacher = entry.getValue();

                // String to write at each line
                String line = teacher.getStaffID() + "," +
                        teacher.getStaffName() + "," +
                        teacher.getExpertise() + "," +
                        (teacher.getAvailability() ? "1" : "0") + "," +
                        teacher.getAssignedTrainings();

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Teachers data saved to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setInstance(DatabaseManager mockInstance) {
        dBManager = mockInstance;
    }
}
