# State Pattern: Document Review Example

## Overview
The **State Pattern** allows an object to change its behavior when its internal state changes. This pattern is particularly useful when an object has different behaviors that depend on its current state. The object (in this case, a document) delegates behavior to the current state, allowing it to operate differently in different states (e.g., Draft, Review, or Published).

### Use Case
In this example, a `Document` moves through several states: `DraftState`, `ReviewState`, and `PublishedState`. Each state dictates what actions are allowed (e.g., editing, submitting for review, or publishing).

### Workflow

1. **Context Initialization**: A `Document` starts in the `DraftState`. In this state, the document can be edited freely.
   
2. **State Transition**: When the document is ready for review, it transitions to the `ReviewState`. In this state, the document can no longer be edited but can be reviewed by authorized personnel.

3. **State-Specific Behavior**: Each state has its own specific behavior. For example, in the `DraftState`, the document can be edited, but in the `PublishedState`, no changes are allowed.

4. **Seamless Transitions**: The `Document` can transition from one state to another based on certain conditions, such as when a draft is submitted for review or when a reviewed document is approved for publishing.

### Entities and Realtionships

- **Document (Context)**: The main entity that manages its state and delegates behavior to the current state.
- **States (Draft, Review, Published)**: The `Document` can be in one of these states at any given time. Each state implements specific behavior for the document (e.g., editing, reviewing, publishing).
- **State Transitions**: The `Document` can transition between different states (e.g., from `DraftState` to `ReviewState`), depending on conditions and operations performed.

### Benefits of the State Pattern
- **Simplified Control Flow**: The pattern avoids complex conditional statements for state management. Instead, the state-specific behavior is encapsulated within each state class.
- **Single Responsibility Principle**: Each state class is responsible for handling the behavior related to that particular state.
- **Maintainability**: Adding or modifying states can be done independently without affecting the rest of the system.
