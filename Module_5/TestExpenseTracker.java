package Module_5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {

    public static String menu() {
        return "\nWelcome to the Expense Tracket\n\n" +
               "MENU OPTIONS\n" +
               "1. View Transactions\n" +
               "2. Add Transactions\n" +
               "3. View Expense\n\n" +
               "Please choose an option: ";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {
            int input = ValidatorIO.getInt(sc, menu());

            if (input == 1) {
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    System.out.println("\nMONTHLY EXPENSES\n");
                    for (Transaction transaction : transactions) {
                        System.out.printf("Date: %s%n", transaction.getDate());
                        System.out.printf("Description: %s%n", transaction.getDescription());
                        System.out.printf("Amount: $%,6.2f%n%n", transaction.getAmount());
                    }
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            } else if (input == 2) {
                String c = "y";
                ArrayList<Transaction> transactions = new ArrayList<>();

                while (c.equalsIgnoreCase("y")) {
                    String description = ValidatorIO.getString(sc, "\nEnter the description: ");
                    double amount = ValidatorIO.getDouble(sc, "Enter the amount: ");

                    Transaction transaction = new Transaction();
                    transaction.setDate(java.time.LocalDate.now().format(
                            java.time.format.DateTimeFormatter.ofPattern("MM-dd-yyyy")));
                    transaction.setDescription(description);
                    transaction.setAmount(amount);

                    transactions.add(transaction);

                    c = ValidatorIO.getString(sc, "\nAdd another transaction? (y/n): ");
                }

                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            } else if (input == 3) {
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    double monthlyExpense = 0;

                    for (Transaction transaction : transactions) {
                        monthlyExpense += transaction.getAmount();
                    }

                    System.out.printf("%nYour total monthly expense is $%,6.2f%n%n", monthlyExpense);
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            }

            String cont = ValidatorIO.getString(sc, "Continue? (y/n): ");
            if (!cont.equalsIgnoreCase("y")) {
                keepGoing = false;
                System.out.println("\nProgram terminated by the user...");
            }
        }

        sc.close();
    }
}
