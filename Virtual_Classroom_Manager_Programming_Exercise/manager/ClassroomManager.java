package manager;

import model.Classroom;
import exception.ClassroomNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ClassroomManager {
    private static final Logger logger = Logger.getLogger(ClassroomManager.class.getName());
    private static ClassroomManager instance;
    private Map<String, Classroom> classrooms;

    private ClassroomManager() {
        classrooms = new HashMap<>();
    }

    public static ClassroomManager getInstance() {
        if (instance == null) {
            instance = new ClassroomManager();
        }
        return instance;
    }

    public void addClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            classrooms.put(className, new Classroom(className));
            logger.info("Classroom " + className + " has been created.");
        } else {
            logger.warning("Classroom " + className + " already exists.");
        }
    }

    public void removeClassroom(String className) {
        if (classrooms.containsKey(className)) {
            classrooms.remove(className);
            logger.info("Classroom " + className + " has been removed.");
        } else {
            logger.warning("Classroom " + className + " does not exist.");
        }
    }

    public Classroom getClassroom(String className) throws ClassroomNotFoundException {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            throw new ClassroomNotFoundException("Classroom " + className + " not found.");
        }
        return classroom;
    }

    public void listClassrooms() {
        classrooms.keySet().forEach(className -> {
            System.out.println("Classroom: " + className);
        });
    }
}
