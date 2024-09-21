# Virtual Classroom Manager

## Overview

The **Virtual Classroom Manager** is a console-based backend application designed for a virtual education platform. It manages the lifecycle of classrooms, students, and assignments in a structured and scalable way. The project focuses on implementing best practices like SOLID principles, object-oriented programming (OOP), and design patterns, with a strong emphasis on code quality, maintainability, and performance.

---

## Key Features

1. **Classroom Management**:
   - **Create a Classroom**: You can create virtual classrooms using a simple command, with each classroom uniquely identified by its name.
   - **List Classrooms**: Displays all available classrooms.
   - **Remove Classrooms**: Delete a classroom from the system.

2. **Student Management**:
   - **Enroll Students**: Add students to a classroom by specifying the student’s ID and the classroom name.
   - **List Students**: View all students enrolled in a specific classroom.

3. **Assignment Management**:
   - **Schedule Assignments**: Assignments can be scheduled for any classroom, ensuring that assignments are tied to their respective classrooms.
   - **Submit Assignments**: Students can submit their assignments for a particular classroom and assignment.
   - **Duplicate Handling**: The system ensures that duplicate assignments are not scheduled or submitted.

---

## Implementation Details

### Design Patterns

1. **Singleton Pattern**: 
   - Used in `ClassroomManager` to ensure only one instance of the classroom manager is created. This helps maintain a centralized store for all classrooms and students.
   
2. **Factory Pattern**:
   - The system uses factory-style object creation to instantiate `Classroom`, `Student`, and `Assignment` objects dynamically based on user input.


### Code Structure

- **Separation of Concerns**: Each component (Classroom, Student, Assignment) has its own dedicated class. Managers (e.g., `ClassroomManager`, `StudentManager`) handle the logic for adding, removing, and retrieving data related to these components.
  
- **Logging**: Comprehensive logging is implemented using Java’s `Logger`. Each critical operation, such as adding a classroom or scheduling an assignment, is logged for better traceability.

- **Exception Handling**:
   - Custom exceptions like `ClassroomNotFoundException` and `StudentNotFoundException` are used to handle error cases gracefully, ensuring that invalid operations (e.g., enrolling a student in a non-existent classroom) don’t crash the system.

- **Validation**:
   - The application performs validation checks to ensure no duplicate classrooms or students are added. It also checks for invalid submissions or assignments to maintain consistency.

---

## How the Project is Implemented

1. **Classroom Management**:
   - The `ClassroomManager` class is responsible for handling the operations around classrooms. It manages a map of classrooms and ensures that classrooms are added or removed properly. The map uses classroom names as keys, making retrieval efficient.

2. **Student Management**:
   - The `StudentManager` handles enrolling and listing students. It ensures that students are uniquely identified by their ID and prevents duplicate enrollments in the same classroom.

3. **Assignment Management**:
   - The `AssignmentManager` allows teachers to schedule assignments for their classrooms. It validates that an assignment can only be scheduled once per class, and that a student can only submit an assignment once.

4. **Interaction Flow**:
   - The main class `VirtualClassroomApp` controls the overall flow, taking user input to execute commands like adding a classroom, enrolling a student, or scheduling an assignment.

---

## Key Concepts and Best Practices Followed

1. **SOLID Principles**:
   - The project is designed with SOLID principles in mind:
     - **Single Responsibility**: Each class has a specific responsibility (e.g., `ClassroomManager` only manages classroom-related logic).
     - **Open/Closed Principle**: The system is open to extension (e.g., adding more functionality like grading assignments) without modifying existing code.
     - **Dependency Inversion**: The `ClassroomManager` provides a single point of interaction for classroom-related operations.

2. **Object-Oriented Programming (OOP)**:
   - Encapsulation: The fields and methods are encapsulated within their respective classes.
   - Abstraction: Only essential details are exposed to the users of the system, while internal complexity is hidden.
   - Polymorphism: Custom exceptions and object creation are extensible, allowing the system to adapt and grow.

---

## Logging and Exception Handling

- **Logging**: Logging is added at key points to trace system events like the creation of classrooms, student enrollments, and assignment submissions.
- **Exception Handling**: The code ensures that exceptions are properly caught and handled. Custom exceptions provide meaningful error messages, ensuring smooth user interactions.

---

## Future Enhancements

- **Persistence**: Currently, the system operates in-memory. The next step would be to persist data to a database for long-term storage.
- **Assignment Grading**: Extend the application to handle assignment grading by teachers.
- **Real-Time Notifications**: Implement an observer pattern to notify students when new assignments are scheduled.

---

## Conclusion

The **Virtual Classroom Manager** provides a robust and scalable system for managing virtual classrooms. It is built with best practices, including design patterns and SOLID principles, making it easy to extend and maintain. The system is designed to be flexible and adaptable for future improvements, ensuring that it can handle more complex use cases in a real-world educational platform.
