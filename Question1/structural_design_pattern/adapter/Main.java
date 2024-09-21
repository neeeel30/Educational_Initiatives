public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new ThirdPartyPaymentAdapter(new ThirdPartyPaymentGateway());
        paymentProcessor.processPayment(150.00);
    }
}