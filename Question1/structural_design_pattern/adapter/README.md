# Adapter Pattern: Payment Gateway Integration

## Overview

The Adapter pattern in this implementation serves to integrate a third-party payment gateway into our system. Our system has a standard interface (`PaymentProcessor`), but the third-party gateway has a different interface. By using an adapter, we enable compatibility between the two without modifying the core system or the third-party library.

## How It's Implemented

1. **Interface (`PaymentProcessor`)**: This defines a standard way to process payments in our system. It has a single method `processPayment(double amount)` that all payment processors must implement.

2. **Third-Party Payment Gateway (`ThirdPartyPaymentGateway`)**: This is an external system that our program needs to use, but its method `makePayment(double amount)` doesn't match the expected `PaymentProcessor` interface.

3. **Adapter (`ThirdPartyPaymentAdapter`)**: The adapter implements the `PaymentProcessor` interface and adapts the third-party gateway by translating the `processPayment()` method into the gateway’s `makePayment()` method.

4. **Client**: The client is unaware of the third-party gateway’s inner workings. It only interacts with the `PaymentProcessor` interface, ensuring that the program remains flexible and adaptable to future changes.

## Key Decisions and Best Practices

### File Structure:

- Each class is placed in a separate file following best practices:
  - `PaymentProcessor.java`
  - `ThirdPartyPaymentGateway.java`
  - `ThirdPartyPaymentAdapter.java`
  - `Main.java`
  
  This ensures a clean, modular structure that's easy to maintain and extend.

### Long-term Program Execution:
- The design avoids hardcoding constructs like `while(true)` loops. User inputs are managed gracefully through a continuous input-gathering loop, with proper exit conditions defined.
  
### Defensive Programming:
- The adapter ensures that all inputs are validated before calling the third-party gateway to prevent invalid data from being processed.
- Defensive programming practices like null checks and validations are applied, protecting against unforeseen errors.

### Performance Optimization:
- The adapter is designed to cache gateway initialization to reduce redundant instantiations, ensuring efficient memory usage.
- We also use lazy loading to instantiate the third-party gateway only when it’s actually needed, optimizing resource utilization.

### Example Workflow:

1. The client interacts with the `PaymentProcessor` interface.
2. The `ThirdPartyPaymentAdapter` adapts the call to the `makePayment()` method of the third-party gateway.
3. The third-party gateway processes the payment, and the adapter returns the result back to the client.

This design ensures that the system is flexible and can handle new payment gateways in the future by simply adding new adapters, without needing to rewrite the client code.
