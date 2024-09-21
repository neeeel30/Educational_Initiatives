package manager;

import model.Assignment;
import model.Classroom;
import exception.ClassroomNotFoundException;
import exception.StudentNotFoundException;
import java.util.logging.Logger;

public class AssignmentManager {
    private static final Logger logger = Logger.getLogger(AssignmentManager.class.getName());

    // Schedule an assignment, log if it's newly scheduled or already exists
    public void scheduleAssignment(String className, String assignmentDetails) {
        ClassroomManager classroomManager = ClassroomManager.getInstance();
        try {
            Classroom classroom = classroomManager.getClassroom(className);

            // Check if the assignment already exists
            boolean assignmentExists = classroom.getAssignments().stream()
                .anyMatch(assignment -> assignment.getDetails().equals(assignmentDetails));

            if (!assignmentExists) {
                Assignment assignment = new Assignment(assignmentDetails);
                classroom.addAssignment(assignment);
                logger.info("Assignment for " + className + " has been scheduled.");
            } else {
                // If assignment already exists, log the appropriate message
                logger.info("Assignment for " + className + " has already been scheduled.");
            }
        } catch (ClassroomNotFoundException e) {
            logger.warning(e.getMessage());
        }
    }

    // Submit an assignment, ensuring assignment exists and no multiple submissions of the same assignment
    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        ClassroomManager classroomManager = ClassroomManager.getInstance();
        try {
            Classroom classroom = classroomManager.getClassroom(className);

            // Check if the student exists in the classroom
            boolean studentExists = classroom.getStudents().stream()
                .anyMatch(s -> s.getId().equals(studentId));
            if (!studentExists) {
                throw new StudentNotFoundException("Student " + studentId + " not found in class " + className + ".");
            }

            // Check if the assignment exists in the class
            Assignment assignment = classroom.getAssignments().stream()
                .filter(a -> a.getDetails().equals(assignmentDetails))
                .findFirst()
                .orElse(null);

            if (assignment == null) {
                logger.warning("Assignment " + assignmentDetails + " does not exist in class " + className + ".");
                return;
            }

            // Check if the student has already submitted this assignment
            boolean assignmentSubmitted = assignment.getSubmittedBy().contains(studentId);

            if (!assignmentSubmitted) {
                // Log the assignment submission and mark it as submitted by the student
                assignment.getSubmittedBy().add(studentId);
                logger.info("Assignment submitted by Student " + studentId + " in " + className + ".");
            } else {
                // If the student has already submitted this assignment, log a message
                logger.info("Assignment already submitted by Student " + studentId + " in " + className + ".");
            }
        } catch (ClassroomNotFoundException | StudentNotFoundException e) {
            logger.warning(e.getMessage());
        }
    }
}
