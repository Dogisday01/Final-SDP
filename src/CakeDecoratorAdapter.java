public class CakeDecoratorAdapter {
    private CakeDecorator cake;

    public CakeDecoratorAdapter(CakeDecorator cake) {
        this.cake = cake;
    }

    public String getCake() {
        return ("Half" + cake.getCake());
    }
}
