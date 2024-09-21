public class ThirdPartyPaymentAdapter implements PaymentProcessor {
    private ThirdPartyPaymentGateway gateway;

    public ThirdPartyPaymentAdapter(ThirdPartyPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}