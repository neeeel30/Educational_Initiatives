import manager.ClassroomManager;
import manager.StudentManager;
import manager.AssignmentManager;

import java.util.Scanner;
import java.util.logging.Logger;

public class VirtualClassroomApp {
    private static final Logger logger = Logger.getLogger(VirtualClassroomApp.class.getName());
    private static ClassroomManager classroomManager = ClassroomManager.getInstance();
    private static StudentManager studentManager = new StudentManager();
    private static AssignmentManager assignmentManager = new AssignmentManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Virtual Classroom Manager!");
        while (true) {
            System.out.println("Enter command (type 'exit' to quit): ");
            String command = scanner.nextLine();
            processCommand(command);
        }
    }

    private static void processCommand(String command) {
        String[] parts = command.split("\\s+");
        String mainCommand = parts[0];

        switch (mainCommand) {
            case "add_classroom":
                if (parts.length == 2) {
                    String className = parts[1];
                    classroomManager.addClassroom(className);
                } else {
                    System.out.println("Invalid command. Usage: add_classroom <className>");
                }
                break;

            case "remove_classroom":
                if (parts.length == 2) {
                    String className = parts[1];
                    classroomManager.removeClassroom(className);
                } else {
                    System.out.println("Invalid command. Usage: remove_classroom <className>");
                }
                break;

            case "add_student":
                if (parts.length == 3) {
                    String studentId = parts[1];
                    String className = parts[2];
                    studentManager.addStudent(studentId, className);
                } else {
                    System.out.println("Invalid command. Usage: add_student <studentId> <className>");
                }
                break;

            case "schedule_assignment":
                if (parts.length == 3) {
                    String className = parts[1];
                    String assignmentDetails = parts[2];
                    assignmentManager.scheduleAssignment(className, assignmentDetails);
                } else {
                    System.out.println("Invalid command. Usage: schedule_assignment <className> <assignmentDetails>");
                }
                break;

            case "submit_assignment":
                if (parts.length == 4) {
                    String studentId = parts[1];
                    String className = parts[2];
                    String assignmentDetails = parts[3];
                    assignmentManager.submitAssignment(studentId, className, assignmentDetails);
                } else {
                    System.out.println("Invalid command. Usage: submit_assignment <studentId> <className> <assignmentDetails>");
                }
                break;

            case "list_classrooms":
                classroomManager.listClassrooms();
                break;

            case "list_students":
                if (parts.length == 2) {
                    String className = parts[1];
                    studentManager.listStudents(className);
                } else {
                    System.out.println("Invalid command. Usage: list_students <className>");
                }
                break;

            case "exit":
                System.out.println("Exiting Virtual Classroom Manager. Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid command.");
        }
    }
}
