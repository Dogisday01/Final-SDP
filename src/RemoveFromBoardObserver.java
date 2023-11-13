public class RemoveFromBoardObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println(message + " и убран с табло заказов.");
    }
}

