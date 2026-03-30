package Module_2.JarPracticeFIles;

public class MartinezTeam {
    private String teamName;
    private String[] players;
    private int playerCount;

    public MartinezTeam(String teamName) {
        this.teamName = teamName;
        this.players = new String[20];
        this.playerCount = 0;
    }

    public void addPlayer(String playerName) {
        if (playerCount < players.length) {
            players[playerCount] = playerName;
            playerCount++;
        }
    }

    public String[] getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getTeamName() {
        return teamName;
    }
}
