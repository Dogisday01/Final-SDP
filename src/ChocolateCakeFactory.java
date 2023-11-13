public class ChocolateCakeFactory implements CakeFactory {
    public Cake createCake() {
        Cake cake = new Cake();
        cake.setType("Chocolate");
        cake.setSize("Medium");
        cake.setCream("Chocolate Cream");
        cake.setFilling("Chocolate Filling");
        return cake;
    }
}
