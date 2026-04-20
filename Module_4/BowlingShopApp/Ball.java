package Module_4.BowlingShopApp;

public class Ball extends Product {
    private String color;

    public Ball() {
        super();
        color = "";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Color: %s%n", color);
    }
}
