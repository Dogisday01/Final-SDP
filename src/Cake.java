public class Cake implements Cloneable{
    private String type;
    private String size;
    private String cream;
    private String filling;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCream() {
        return cream;
    }

    public void setCream(String cream) {
        this.cream = cream;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public Cake clone() throws CloneNotSupportedException{
        return (Cake) super.clone();
    }
}
