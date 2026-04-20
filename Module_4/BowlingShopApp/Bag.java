package Module_4.BowlingShopApp;

// This class will be getting attributes from the Product class yet will be creating custom methods for this Bag class

public class Bag extends Product {
    private String type;

    public Bag() {
        super();
        type = "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Type: %s%n", type);
    }
}
