package manager;

import model.Student;
import model.Classroom;
import exception.ClassroomNotFoundException;
import java.util.List;
import java.util.logging.Logger;

public class StudentManager {
    private static final Logger logger = Logger.getLogger(StudentManager.class.getName());

    public void addStudent(String studentId, String className) {
        ClassroomManager classroomManager = ClassroomManager.getInstance();
        try {
            Classroom classroom = classroomManager.getClassroom(className);

            // Check if a student with the same ID already exists in the classroom
            List<Student> students = classroom.getStudents();
            for (Student student : students) {
                if (student.getId().equals(studentId)) {
                    System.out.println("Student with ID " + studentId + " is already enrolled in " + className);
                    return;  // Exit the method to avoid duplicate enrollment
                }
            }

            // If the student does not exist, enroll them
            Student student = new Student(studentId, className);
            classroom.addStudent(student);
            logger.info("Student " + studentId + " has been enrolled in " + className + ".");
        } catch (ClassroomNotFoundException e) {
            logger.warning(e.getMessage());
        }
    }

    public void listStudents(String className) {
        ClassroomManager classroomManager = ClassroomManager.getInstance();
        try {
            Classroom classroom = classroomManager.getClassroom(className);
            List<Student> students = classroom.getStudents();
            if (students.isEmpty()) {
                System.out.println("No students enrolled in " + className);
            } else {
                System.out.println("Students in " + className + ":");
                students.forEach(student -> System.out.println("Student ID: " + student.getId()));
            }
        } catch (ClassroomNotFoundException e) {
            logger.warning(e.getMessage());
        }
    }
}
