package Module_5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";
    private static final File file = new File(FILE_NAME);

    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;

        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else {
            output = new PrintWriter(FILE_NAME);
        }

        for (Transaction tran : transactions) {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }

        output.close();
    }

    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (!file.exists()) {
            file.createNewFile();
            return transactions;
        }

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String date = input.next();
            String description = input.next();
            double amount = input.nextDouble();

            Transaction transaction = new Transaction(date, description, amount);
            transactions.add(transaction);
        }

        input.close();
        return transactions;
    }
}