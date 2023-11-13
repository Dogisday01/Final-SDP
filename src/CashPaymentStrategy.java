public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Оплата наличными");
    }
}