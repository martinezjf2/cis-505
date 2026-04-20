package Module_4.BowlingShopApp;

// Created another product that extends from the Product class which allows us to retreive important information/methods such as price, and description

public class Shoe extends Product {
    private double size;

    public Shoe() {
        super();
        size = 0;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Size: %6.2f%n", size);
    }
}