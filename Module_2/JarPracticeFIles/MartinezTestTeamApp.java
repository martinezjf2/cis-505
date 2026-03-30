package Module_2.JarPracticeFIles;
import java.util.Scanner;

public class MartinezTestTeamApp {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        System.out.println("Welcome to the Sports Team App");
        System.out.println();

        do {
            System.out.print("Enter a team name: ");
            String teamName = input.nextLine();
            System.out.println();

            MartinezTeam team = new MartinezTeam(teamName);

            System.out.println("Enter the player names:");
            System.out.print("hint: use commas for multiple players; no spaces>: ");
            String playerInput = input.nextLine();
            System.out.println();

            String[] playerList = playerInput.split(",");

            for (String player : playerList) {
                team.addPlayer(player);
            }

            System.out.println("--Team Summary--");
            System.out.println("Number of players in team: " + team.getPlayerCount());

            System.out.print("Players on team: ");
            String[] players = team.getPlayers();
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(players[i] + ",");
            }
            System.out.println();
            System.out.println();

            System.out.print("Continue? (y/n): ");
            choice = input.nextLine();
            System.out.println();

        } while (choice.equalsIgnoreCase("y"));

        System.out.println("End of line...");
        input.close();
    }
}
