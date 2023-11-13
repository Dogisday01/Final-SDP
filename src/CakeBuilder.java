public class CakeBuilder {
    private Cake cake;

    public CakeBuilder(String type, String size) {
        cake = new Cake();
        cake.setType(type);
        cake.setSize(size);
    }

    public CakeBuilder withCream(String cream) {
        cake.setCream(cream);
        return this;
    }

    public CakeBuilder withFilling(String filling) {
        cake.setFilling(filling);
        return this;
    }

    public Cake build() {
        return cake;
    }
}
