public class BoardObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("В табло заказов " + message);
    }
}
