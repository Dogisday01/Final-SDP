public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Оплата картой");
    }
}