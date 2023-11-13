public class CakeDecorator {
    private Cake cake;

    public CakeDecorator(Cake cake){
        this.cake = cake;
    }

    public String getCake(){
        return (this.cake.getType() + " cake with " + this.cake.getSize() + " size, " + this.cake.getCream() +", and " + this.cake.getFilling());
    }
}
