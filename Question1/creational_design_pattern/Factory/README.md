# Factory Design Pattern

## Overview

The **Factory Design Pattern** is one of the most commonly used creational patterns. It provides a way to encapsulate object creation in a central place while keeping the client code independent of specific classes. This promotes **loose coupling**, as the client doesn't need to know the details of how objects are created, but only which objects are available and can be requested from the factory.

In this example, we have implemented a **notification system** where different types of notifications (SMS, Email, Push Notification) can be created based on user input. This allows the system to handle multiple notification types without altering the client code when a new notification type is introduced.

## Workflow

1. **Interface Definition**: 
   - All notification types implement the `Notification` interface. This interface guarantees that all concrete notification types (e.g., SMS, Email) provide a `notifyUser()` method, ensuring uniformity in the behavior of different notification types.

2. **Concrete Classes**: 
   - The concrete classes (`SMSNotification`, `EmailNotification`, `PushNotification`) each implement the `Notification` interface. These classes define how each notification type behaves when `notifyUser()` is called. For example, `SMSNotification` sends an SMS, while `EmailNotification` sends an email.

3. **Factory Class**: 
   - The `NotificationFactory` class is the heart of the design pattern. It takes in user input (a string representing the type of notification) and uses a **switch case** or **if-else** logic to create and return the appropriate notification type. 
   - If the user input is invalid or unrecognized, the factory throws an exception, ensuring **defensive programming**.

4. **Client Code**: 
   - The client only interacts with the factory. It doesn't directly create instances of `SMSNotification`, `EmailNotification`, etc. Instead, the client calls the factory and asks it to create a notification. This approach decouples the client from knowing which concrete class is being instantiated.

## Flowchart

Below is a simple flowchart that describes the workflow of the **Factory Design Pattern**:

```plaintext
 +-----------------------+
 | Client Requests        |
 | Notification           |
 +-----------+-----------+
             |
             v
 +-----------+-----------+
 | NotificationFactory    |
 | Determines Notification|
 | Type Based on Input    |
 +-----------+-----------+
             |
   +---------+---------+
   |                   |
   v                   v
+-----------+     +-----------+
| SMSNotification|  | EmailNotification |
+-----------+     +-----------+
             |
             v
 +-----------+-----------+
 | notifyUser() Called    |
 | Sends Notification     |
 +-----------------------+
