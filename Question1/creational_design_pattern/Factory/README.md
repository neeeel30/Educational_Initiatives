# Factory Design Pattern

## Overview

The **Factory Design Pattern** is a creational design pattern used to abstract the process of creating objects, allowing the system to instantiate objects dynamically based on input, without the client needing to specify the exact class. This approach makes the system modular and scalable, promoting loose coupling.

## How It Is Implemented

### Project Structure and Organization

- Each notification type (`SMSNotification`, `EmailNotification`, `PushNotification`) is organized into its own file to maintain separation of concerns and ensure adherence to global best practices.
- The `NotificationFactory` class, responsible for creating objects, is in a separate file to keep the object creation logic centralized.
- The program architecture allows scalability, where new notification types can be added without modifying the existing client code. This is possible because the client interacts only with the `NotificationFactory` and the common `Notification` interface.

### Workflow

1. **Interface Definition**:
   A `Notification` interface defines the method that each notification class must implement, enforcing uniformity. Each type of notification (SMS, Email, Push) will adhere to this interface.

2. **Concrete Implementations**:
   Each notification class (e.g., `SMSNotification`, `EmailNotification`) implements the `Notification` interface, providing its own logic for sending a message.

3. **Factory Class**:
   The `NotificationFactory` is responsible for creating the specific notification object based on the input provided (e.g., `sms`, `email`). This class handles object creation centrally, reducing the client’s knowledge of concrete implementations.

4. **Client Interaction**:
   The client interacts with the `NotificationFactory` to obtain instances of notification objects. The factory determines the correct notification type to create, based on the input from the user.

### Key Design Decisions

- **Decoupling**: By delegating the object creation to the factory, we reduce dependencies between the client and the specific notification types, adhering to the principle of loose coupling.
- **Extensibility**: New notification types can be added by implementing the `Notification` interface and updating the factory without changing existing client code.
- **Organization**: Each class is organized into separate files, making it easier to manage, maintain, and test.
- **No Hard Coding**: No hardcoded loops or flags such as `while(true)` exist. Input handling and looping logic are designed to handle user inputs efficiently without infinite loops.

### Key Optimizations

- **Logging**: The system incorporates logging to track when notifications are created and sent, which aids in monitoring and debugging.
- **Exception Handling**: Any invalid input, such as an unsupported notification type, triggers a specific exception, ensuring that the system fails gracefully.
- **Defensive Programming**: Input validation ensures that null or invalid inputs are handled appropriately, preventing runtime errors and enhancing robustness.
- **Performance**: The system is optimized to handle multiple notifications by reusing common logic and reducing unnecessary object creation.

### Long-Term Considerations

- The factory pattern allows the system to gather user input indefinitely. The system doesn't use hardcoded loops like `while(true)`; instead, it leverages a flexible input-handling mechanism that lets the program run for long durations without freezing or performance bottlenecks.

## Summary

The Factory Design Pattern in this project ensures scalability, flexibility, and maintainability by abstracting object creation logic. It follows global best practices such as separating classes into individual files, robust exception handling, and defensive programming principles.
