# Design Patterns

This repository contains examples of the Adapter and Composite design patterns implemented in Java.

## Adapter Pattern

### Overview

The Adapter pattern is a structural design pattern that allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces, enabling the integration of existing code with new systems without modifying the original code.

### Workflow

1. **Interface Definition:** We define a common interface that the client can use. In our case, this is the `PaymentProcessor` interface.
2. **Existing Class:** The existing class, `ThirdPartyPaymentGateway`, has a specific method for processing payments (`makePayment`), which does not match the new interface.
3. **Adapter Class:** The `ThirdPartyPaymentAdapter` implements the `PaymentProcessor` interface and wraps the `ThirdPartyPaymentGateway` class. This adapter translates the calls from the `PaymentProcessor` interface to the method in `ThirdPartyPaymentGateway`.
4. **Client Code:** The client interacts with the `PaymentProcessor` interface. When a payment is processed, it uses the adapter, which then delegates the call to the legacy gateway.

### Key Benefits
- **Reusability:** The Adapter pattern allows us to reuse existing classes with minimal changes.
- **Flexibility:** New classes can be integrated easily by creating additional adapters.

