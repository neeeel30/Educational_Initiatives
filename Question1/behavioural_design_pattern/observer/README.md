# Observer Pattern: Stock Price Example

## Overview
The **Observer Pattern** establishes a one-to-many relationship between a subject (Stock) and its observers (Investors). The core idea is that when the stock price changes, all observers are notified of the change, making it highly effective for decoupling the subject from the observers. The subject doesn’t need to know anything about the observers, ensuring loose coupling.

### What It Has

1. **Stock (Subject)**:
   - The `Stock` class manages the stock price and keeps track of registered observers (Investors).
   - It follows best practices for adding and removing observers through methods like `addObserver()` and `removeObserver()`.
   - Stock price changes trigger an update to all observers via the `notifyAllObservers()` method, adhering to the Observer pattern structure.

2. **Investor (Observer)**:
   - The `Investor` interface defines the `update()` method that all investors implement to handle stock price changes.
   - This separation allows easy extensibility, adding more investor types in the future without altering the core `Stock` class.

3. **Gold Standards**:
   - **No Infinite Loops**: The design avoids any `while(true)` infinite loops for gathering user input. Instead, input is handled using proper methods.
   - **Logging and Exception Handling**: Exception handling and logging are implemented using standard Java `try-catch` blocks. For example, invalid stock price updates throw an exception, and all significant actions (like stock price updates and investor notifications) are logged for future tracking and debugging.
   - **Performance Optimizations**: The system uses efficient collection types to store and notify observers. Observer notifications are handled asynchronously for better performance, especially when dealing with large numbers of observers.
   - **Defensive Programming**: Methods in the `Stock` class check for null values and ensure that observers are only notified when actual changes occur, avoiding redundant notifications.

### How It Is Implemented

- **Subject and Observer Relationship**: 
  - The `Stock` class holds a list of observers (`Investor` objects) that are interested in changes to the stock price.
  - When the stock price changes, it uses the `notifyAllObservers()` method to inform all registered observers.
  - Each observer’s `update()` method is called with the new stock price, allowing them to react accordingly.

- **Key Decisions**:
  - The separation of concerns between the subject and its observers ensures a maintainable and flexible system.
  - Each investor defines its behavior through the `update()` method, allowing independent handling of the notification logic.
  - The `Stock` class is responsible only for managing investors and notifying them, not how the notification is handled.

- **Why This Design?**
  - By adhering to the **Observer Pattern**, we ensure that any new investor types can be added without modifying the stock logic.
  - The use of an interface for `Investor` allows multiple implementations with minimal dependencies between the stock and investors, promoting **loose coupling**.
  - This implementation also supports future scalability and extension while maintaining performance and a clean, maintainable code structure.
