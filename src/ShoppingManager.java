import java.util.ArrayList;
import java.util.List;

class ShoppingManager {
    private static ShoppingManager instance;
    private List<Observer> observers = new ArrayList<>();

    private ShoppingManager() {
        // private конструктор для Singleton
    }

    public static synchronized ShoppingManager getInstance() {
        if (instance == null) {
            instance = new ShoppingManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addToCart(Cake cake) {
        // Логика добавления в корзину
        CakeDecorator cakeDecorator = new CakeDecorator(cake);
        notifyObservers("Добавлен: " + cakeDecorator.getCake());
    }

    public void ready(Cake cake) {
        // Логика оплаты
        CakeDecorator cakeDecorator = new CakeDecorator(cake);
        notifyObservers("Оплачен: " + cakeDecorator.getCake());
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
        System.out.println("");
    }
}