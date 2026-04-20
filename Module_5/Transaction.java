package Module_5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String date;
    private String description;
    private double amount;

    public Transaction() {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        this.description = "";
        this.amount = 0;
    }

    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Date: %s%nDescription: %s%nAmount: $%,6.2f%n",
                date, description, amount);
    }
}