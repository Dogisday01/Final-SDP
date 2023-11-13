public class VanillaCakeFactory implements CakeFactory {
    public Cake createCake() {
        Cake cake = new Cake();
        cake.setType("Vanilla");
        cake.setSize("Small");
        cake.setCream("Vanilla Cream");
        cake.setFilling("Vanilla Filling");
        return cake;
    }
}
