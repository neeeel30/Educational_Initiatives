# Prototype Design Pattern

## Overview

The **Prototype Design Pattern** is a creational design pattern used to create duplicate objects while ensuring performance optimization and avoiding expensive object creation. Instead of instantiating new objects from scratch, the prototype pattern allows you to create new objects by cloning existing ones, making it useful when object creation is resource-intensive or when a system needs multiple copies of similar objects.

In this example, we demonstrate the **Prototype Pattern** by implementing a **UserProfile** class with fields like `name`, `email`, and `address`. Instead of creating new instances of `UserProfile` from scratch every time, we clone an existing profile to create similar ones with slight modifications.

## Workflow

1. **Prototype Object**:
   - The `UserProfile` class represents a user's profile and implements the `Cloneable` interface in Java. By doing this, the class can create a copy of itself through the `clone()` method.
   - The `UserProfile` contains an instance of an `Address` class, which also implements the `Cloneable` interface. This ensures that when the `UserProfile` is cloned, the `Address` object is cloned as well, achieving **deep cloning**.

2. **Deep Cloning**:
   - **Deep cloning** means that when a `UserProfile` object is cloned, its `Address` object is also copied, ensuring that both the original and cloned `UserProfile` objects hold separate references to their respective `Address` instances.
   - In this implementation, the `UserProfile` class overrides the `clone()` method to make sure that the deep cloning process works correctly.

3. **Client Code**:
   - The client code creates an initial `UserProfile` instance and then uses the `clone()` method to create copies of it. The cloned `UserProfile` objects can be modified independently of the original one, ensuring no shared references exist between the original and the clone.

4. **Validation**:
   - Proper exception handling ensures that cloning errors, such as if the `Cloneable` interface is not correctly implemented, are caught and handled gracefully. This adds robustness to the system.

## Flowchart

Here’s a visual representation of how the Prototype pattern workflow operates:

```plaintext
 +-------------------------+
 | Client Creates Initial   |
 | UserProfile Object       |
 +-----------+-------------+
             |
             v
 +-----------+-------------+
 | Clone UserProfile Object |
 | (Deep Clone with Address)|
 +-----------+-------------+
             |
   +---------+---------+
   |                   |
   v                   v
+-----------+     +-----------+
| Original Profile| | Cloned Profile  |
| (Original Address)| | (Cloned Address)|
+-----------+     +-----------+
             |
   +---------+---------+
   |                   |
   v                   v
+-----------+     +-----------+
| Modify Data   | | Modify Data   |
+-----------+     +-----------+
