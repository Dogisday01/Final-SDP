class PaymentProcessor {
    public void processPayment(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay();
    }
}