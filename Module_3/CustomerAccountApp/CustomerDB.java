package Module_3.CustomerAccountApp;

public class CustomerDB {
    public static Customer getCustomer(Integer id) {

        if (id == 1007) {
            return new Customer("Alice Smith", "123 Maple St", "Springfield", "62701");
        } else if (id == 1008) {
            return new Customer("Bob Johnson", "456 Oak Ave", "Shelbyville", "62565");
        } else if (id == 1009) {
            return new Customer("Carol Williams", "789 Pine Rd", "Capital City", "62702");
        } else {
            return new Customer();
        }
    }

    public static void main(String[] args) {

        System.out.println("ID 1007:");
        System.out.println(CustomerDB.getCustomer(1007));

        System.out.println("\nID 1008:");
        System.out.println(CustomerDB.getCustomer(1008));

        System.out.println("\nID 1009:");
        System.out.println(CustomerDB.getCustomer(1009));

        System.out.println("\nID 9999 (no match):");
        System.out.println(CustomerDB.getCustomer(9999));
    }
}
