package Module_4.BowlingShopApp;

// This will basically be creating a LinkedList of items depending on what the user has chosen.

public class ProductDB {

    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<>();

        if (code.equalsIgnoreCase("b")) {
            Ball ball1 = new Ball();
            ball1.setCode("B001");
            ball1.setDescription("Hammer Black Widow");
            ball1.setPrice(149.99);
            ball1.setColor("Black");
            products.enqueue(ball1);

            Ball ball2 = new Ball();
            ball2.setCode("B002");
            ball2.setDescription("Storm Phaze II");
            ball2.setPrice(139.99);
            ball2.setColor("Purple");
            products.enqueue(ball2);

            Ball ball3 = new Ball();
            ball3.setCode("B003");
            ball3.setDescription("Ebonite Game Breaker");
            ball3.setPrice(129.99);
            ball3.setColor("Blue");
            products.enqueue(ball3);

            Ball ball4 = new Ball();
            ball4.setCode("B004");
            ball4.setDescription("Motiv Venom Shock");
            ball4.setPrice(134.99);
            ball4.setColor("Green");
            products.enqueue(ball4);

            Ball ball5 = new Ball();
            ball5.setCode("B005");
            ball5.setDescription("Track Tundra Fire");
            ball5.setPrice(144.99);
            ball5.setColor("Red");
            products.enqueue(ball5);

        } else if (code.equalsIgnoreCase("s")) {
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S001");
            shoe1.setDescription("Dexter SST 8");
            shoe1.setPrice(89.99);
            shoe1.setSize(10.5);
            products.enqueue(shoe1);

            Shoe shoe2 = new Shoe();
            shoe2.setCode("S002");
            shoe2.setDescription("Brunswick Vapor");
            shoe2.setPrice(79.99);
            shoe2.setSize(11.0);
            products.enqueue(shoe2);

            Shoe shoe3 = new Shoe();
            shoe3.setCode("S003");
            shoe3.setDescription("KR Strikeforce Flyer");
            shoe3.setPrice(74.99);
            shoe3.setSize(9.5);
            products.enqueue(shoe3);

            Shoe shoe4 = new Shoe();
            shoe4.setCode("S004");
            shoe4.setDescription("Hammer Force");
            shoe4.setPrice(84.99);
            shoe4.setSize(10.0);
            products.enqueue(shoe4);

            Shoe shoe5 = new Shoe();
            shoe5.setCode("S005");
            shoe5.setDescription("Storm SP3");
            shoe5.setPrice(94.99);
            shoe5.setSize(12.0);
            products.enqueue(shoe5);

        } else if (code.equalsIgnoreCase("a")) {
            Bag bag1 = new Bag();
            bag1.setCode("A001");
            bag1.setDescription("2 Ball Deluxe");
            bag1.setPrice(59.99);
            bag1.setType("2-ball");
            products.enqueue(bag1);

            Bag bag2 = new Bag();
            bag2.setCode("A002");
            bag2.setDescription("3 Ball Roller");
            bag2.setPrice(89.99);
            bag2.setType("3-ball");
            products.enqueue(bag2);

            Bag bag3 = new Bag();
            bag3.setCode("A003");
            bag3.setDescription("Tournament Tote");
            bag3.setPrice(39.99);
            bag3.setType("1-ball");
            products.enqueue(bag3);
        }

        return products;
    }
}