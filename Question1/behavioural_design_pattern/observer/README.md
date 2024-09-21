# Observer Pattern: Stock Price Example

## Overview
The **Observer Pattern** establishes a one-to-many relationship between a subject and its observers. When the subject (in this case, a stock) changes its state (such as the stock price), all registered observers (like investors) are automatically notified of the change and can respond accordingly. This design pattern helps promote loose coupling between the subject and observers, making the system more flexible and maintainable.

### Use Case
In this example, the subject is a `Stock` that tracks its price, and the observers are various `Investor` types (e.g., via phone or email) who are interested in stock price changes. When the stock price changes, the `Stock` notifies all registered investors, who then update their displays.

### Workflow

1. **Subject Registration**: Observers (such as `PhoneInvestor` and `EmailInvestor`) register themselves with the subject (the `Stock`), indicating they want to receive updates.
   
2. **State Change**: The stock price fluctuates, and the stock’s internal state changes. This triggers a notification process.

3. **Notification**: The stock notifies all registered observers by calling their `update()` method, passing along the latest stock price.

4. **Observer Response**: Each observer defines its own `update()` method, which handles the stock price change in a unique way (e.g., displaying it on a phone or sending an email).

### Entities and Realtionships

- **Stock (Subject)**: The entity that tracks the stock price and has a one-to-many relationship with the `Investor` entities.
- **Investor (Observer)**: There are multiple investor entities (e.g., `PhoneInvestor`, `EmailInvestor`) that are related to the stock and get notified of price changes.
- **Notification Mechanism**: The `Stock` calls the `update()` method on all registered investors when its price changes.

### Benefits of the Observer Pattern
- **Loose Coupling**: The subject (stock) and observers (investors) are loosely coupled. The subject doesn't need to know about the specifics of the observers.
- **Extensibility**: Adding new observer types (e.g., `TabletInvestor`) is easy without changing the subject or existing observers.
- **Real-time Updates**: All registered observers receive real-time updates when the subject changes its state.
