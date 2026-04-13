package Module_3.CustomerAccountApp;

public class Customer {
    private String name;
    private String address;
    private String city;
    private String zip;

    public Customer() {
        this.name = "";
        this.address = "";
        this.city = "";
        this.zip = "";
    }

    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Name:    " + name +
               "\nAddress: " + address +
               "\nCity:    " + city +
               "\nZip:     " + zip;
    }


    public static void main(String[] args) {
        Customer c1 = new Customer();
        System.out.println("Default Customer:");
        System.out.println(c1);

        System.out.println();

        Customer c2 = new Customer("Alice Smith", "123 Main St", "Springfield", "62701");
        System.out.println("Customer with data:");
        System.out.println(c2);
    }
}
