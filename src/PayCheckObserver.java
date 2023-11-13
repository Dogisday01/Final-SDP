public class PayCheckObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println(message + " и выдан чек");
    }
}
