public class StrawberryCakeFactory implements CakeFactory {
    public Cake createCake() {
        Cake cake = new Cake();
        cake.setType("Strawberry");
        cake.setSize("Large");
        cake.setCream("Strawberry Cream");
        cake.setFilling("Strawberry Filling");
        return cake;
    }
}
