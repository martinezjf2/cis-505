package Module_6.ComposerApp;

import java.util.Scanner;

public class TestComposerApp {

    public static void main(String[] args) {
        MemComposerDao dao = new MemComposerDao();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 4) {
            printMenu();
            System.out.print("Please choose an option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1 -> listComposers(dao);
                case 2 -> findComposer(dao, scanner);
                case 3 -> addComposer(dao, scanner);
                case 4 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Welcome to the Composer App\n");
        System.out.println("MENU OPTIONS\n");
        System.out.println("1. View Composers");
        System.out.println("2. Find Composer");
        System.out.println("3. Add Composer");
        System.out.println("4. Exit\n");
    }


    // Method which will list all composers
    private static void listComposers(MemComposerDao dao) {
        System.out.println("\n--DISPLAYING COMPOSERS--");
        for (Composer c : dao.findAll()) {
            System.out.println(c);
            System.out.println();
        }
    }


    // Make sure to find the composer based on the specific id that the user has inputted. Make sure to have an else for a test case if the id does not exist.
    private static void findComposer(MemComposerDao dao, Scanner scanner) {
        System.out.print("Enter an id: ");
        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            scanner.nextLine();
            Composer c = dao.findBy(id);
            if (c != null) {
                System.out.println("\n--DISPLAYING COMPOSER--\n");
                System.out.println(c);
                System.out.println();
            } else {
                System.out.println("No composer found with ID " + id + ".\n");
            }
        } else {
            scanner.nextLine();
            System.out.println("Invalid ID. Please enter an integer.\n");
        }
    }

    private static void addComposer(MemComposerDao dao, Scanner scanner) {
        System.out.print("Enter an id: ");
        int id;
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
            scanner.nextLine();
        } else {
            scanner.nextLine();
            System.out.println("Invalid ID.\n");
            return;
        }

        System.out.print("Enter a name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter a genre: ");
        String genre = scanner.nextLine().trim();

        dao.insert(new Composer(id, name, genre));
        System.out.println();
    }
}