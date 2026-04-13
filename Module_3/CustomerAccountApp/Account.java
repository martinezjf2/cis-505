package Module_3.CustomerAccountApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {
    private double balance = 200;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        }
    }

    public void displayMenu() {
        System.out.println("Account Menu");
        System.out.println("Enter <D/d> for Deposit");
        System.out.println("Enter <W/w> for Withdraw");
        System.out.println("Enter <B/b> for Balance");
        System.out.print("Enter option>: ");
    }

    public String getTransactionDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return today.format(formatter);
    }

    public static void main(String[] args) {
        Account account = new Account();

        System.out.println("Transaction Date: " + account.getTransactionDate());
        System.out.println();

        account.displayMenu();
        System.out.println();

        System.out.println("Default Balance: $" + account.getBalance());

        account.deposit(500);
        System.out.println("After Deposit of $500: $" + account.getBalance());

        account.withdraw(100);
        System.out.println("After Withdraw of $100: $" + account.getBalance());

        account.withdraw(10000);
        System.out.println("After Withdraw of $10000 (insufficient): $" + account.getBalance());
    }
}
