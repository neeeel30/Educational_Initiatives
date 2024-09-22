# Composite Pattern: Graphical User Interface (GUI) with Shapes

## Overview

The Composite pattern is used here to model a graphical user interface (GUI) with shapes such as circles and rectangles. The idea is to treat both individual shapes and groups of shapes uniformly. We achieve this by defining a common `Graphic` interface that both simple (leaf) objects and composite objects implement.

## How It's Implemented

1. **Interface (`Graphic`)**: This defines a method `draw()` that every graphical object must implement. Both individual shapes (like `Circle` and `Rectangle`) and composite objects (like `CompositeGraphic`) implement this interface.

2. **Leaf Components (`Circle`, `Rectangle`)**: These are individual graphical objects that implement the `Graphic` interface. When their `draw()` method is called, they perform their own specific rendering logic.

3. **Composite Component (`CompositeGraphic`)**: This is the core of the Composite pattern. It also implements the `Graphic` interface but can contain multiple child graphics (either simple shapes or other composites). When `draw()` is called on the composite, it recursively calls `draw()` on all its children.

4. **Client**: The client creates a mixture of simple and composite graphical objects. By calling `draw()` on the composite object, the client triggers a iterative rendering of all shapes in the hierarchy.

## Key Decisions and Best Practices

### File Structure:

- Each class is placed in its own file:
  - `Graphic.java`
  - `Circle.java`
  - `Rectangle.java`
  - `CompositeGraphic.java`
  - `MainComposite.java`
  
  This modular approach ensures easy scalability and maintenance.

### Long-term Program Execution:
- User inputs are gathered in a continuous and controlled manner without hardcoding infinite loops. The system can dynamically accept shapes and draw the hierarchy as needed.

### Logging & Exception Handling:
- **Logging** is implemented at critical points, such as when shapes are added to a composite or when the `draw()` method is called.
- **Exception handling** covers scenarios like attempting to draw an invalid shape or adding unsupported types to the composite.

### Defensive Programming:
- Every method call is guarded by input validations, ensuring that null or malformed objects are never added to a composite.
- The composite structure also performs sanity checks to ensure that no circular references exist (e.g., preventing a composite from being added to itself).

### Performance Optimization:
- The composite structure is optimized for recursive calls. The system minimizes the depth of recursion by handling large hierarchies efficiently.
- Shapes are cached where necessary to reduce redundant processing during drawing operations.

### Example Workflow:

1. The client creates individual shapes like `Circle` and `Rectangle`.
2. A `CompositeGraphic` object is created, and shapes are added to it.
3. The client can also nest multiple `CompositeGraphic` objects to create a complex tree structure.
4. When the `draw()` method is called on the root composite, it recursively renders all shapes in the hierarchy, regardless of whether they are simple shapes or other composites.

This approach ensures scalability, as new shapes or composite objects can be easily added without affecting the client code. The system can handle complex GUI structures efficiently while maintaining clean and understandable code.
