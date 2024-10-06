# State Pattern: Document Review Example

## Overview
The **State Pattern** allows an object to change its behavior based on its internal state. In this example, the `Document` transitions between several states: `DraftState`, `ReviewState`, and `PublishedState`. Each state encapsulates the behavior relevant to that phase of the document’s lifecycle, and the transitions ensure that the document behaves correctly in each state.

### What It Has

1. **Document (Context)**:
   - The `Document` class is the main context that tracks the current state of the document and delegates behavior to the state.
   - It starts in the `DraftState`, allowing editing and submission for review.
   - As the document transitions to `ReviewState` and eventually `PublishedState`, different behaviors are applied. For instance, in the `ReviewState`, editing is restricted, and the document can either be approved or returned to draft.

2. **State Interface and Implementations**:
   - The `State` interface defines the core behaviors for editing, submitting, reviewing, and publishing.
   - Each concrete state (`DraftState`, `ReviewState`, `PublishedState`) implements the state interface, providing state-specific logic.
   - This encapsulates behavior in each state class, adhering to **Single Responsibility Principle** and making the system easy to extend.

3. **Gold Standards**:
   - **State Transition Logic**: Transitions between states are handled seamlessly by calling transition methods (e.g., `review()`, `publish()`), which are guarded with checks to ensure valid transitions.
   - **Optimized and Scalable**: State transitions are efficient, and each state handles its behavior independently, which makes the system easy to scale as more states (e.g., `ArchivedState`) are introduced.
   - **Defensive Programming**: Each state checks if the operations requested are valid in the current state, ensuring robustness and avoiding unexpected errors.

### How It Is Implemented

- **State Transitions**:
  - The `Document` starts in the `DraftState`, where it can be edited freely. When the document is ready for review, it transitions to `ReviewState`.
  - In the `ReviewState`, the document can no longer be edited but can be reviewed and either approved (transitioning to `PublishedState`) or sent back to draft.
  - In the `PublishedState`, no further changes are allowed, and the document is considered final.

- **State-Specific Behavior**:
  - Each state handles document behavior in a different way.
  - Each state is responsible for managing its behavior, ensuring that the `Document` class remains clean and easy to maintain.

- **Key Decisions**:
  - Using the **State Pattern** here ensures that behavior is tied directly to the document's current state, rather than relying on complex conditional logic in the `Document` class.
  - The design provides a clean separation of concerns, where each state encapsulates the logic for that phase of the document lifecycle.
  - The `Document` class simply delegates tasks to the current state, adhering to the **Open-Closed Principle** by allowing new states to be added without modifying the existing state logic.

- **Why This Design?**
  - The State Pattern is ideal for scenarios where an object needs to behave differently depending on its state.
  - By separating behavior into state-specific classes, we ensure that the `Document` class remains maintainable and scalable.
  - This design is easy to extend: for example, adding an `ArchivedState` or other future states can be done without modifying the existing code.
  - The system supports robust exception handling, validation, and performance optimization, ensuring that invalid operations are gracefully handled.
