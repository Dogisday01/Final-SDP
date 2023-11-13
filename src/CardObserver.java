public class CardObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("В чек " + message);
    }
}