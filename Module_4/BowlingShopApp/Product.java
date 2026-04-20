package Module_4.BowlingShopApp;


// This generic class will be used as the parent to any product with custom methods that we can access such as retrieving the description, price. etc.

public class Product {
    private String code;
    private String description;
    private double price;

    public Product() {
        code = "";
        description = "";
        price = 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Code: %s%nDescription: %s%nPrice: $%,6.2f%n",
                code, description, price);
    }
}
