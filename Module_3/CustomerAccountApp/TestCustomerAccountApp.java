package Module_3.CustomerAccountApp;

import java.util.Scanner;

public class TestCustomerAccountApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Customer Account App");
        System.out.println();
        System.out.println("Enter a customer ID:");
        System.out.print("ex: 1007, 1008, 1009>: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = CustomerDB.getCustomer(id);

        Account account = new Account();

        String choice;

        do {
            System.out.println();
            account.displayMenu();
            String option = scanner.nextLine().trim();
            System.out.println();

            if (option.equalsIgnoreCase("D")) {
                System.out.print("Enter deposit amount: ");
                double depositAmt = scanner.nextDouble();
                scanner.nextLine();
                account.deposit(depositAmt);

            } else if (option.equalsIgnoreCase("W")) {
                System.out.print("Enter withdraw amount: ");
                double withdrawAmt = scanner.nextDouble();
                scanner.nextLine();
                account.withdraw(withdrawAmt);

            } else if (option.equalsIgnoreCase("B")) {
                System.out.printf("Account balance: $%,6.2f%n", account.getBalance());

            } else {
                System.out.println("Error: Invalid option");
            }

            System.out.println();
            System.out.print("Continue? (y/n): ");
            choice = scanner.nextLine().trim();

        } while (choice.equalsIgnoreCase("y"));

        System.out.println();
        System.out.println("--Customer Details--");
        System.out.println(customer);
        System.out.println();
        System.out.printf("Balance as of " + account.getTransactionDate() +
                          " is $%,6.2f%n", account.getBalance());
        System.out.println();
        System.out.println("End of line...");

        scanner.close();
    }
}
