package ch.fhnw.atlantis.globalClasses.db;

/**
 *
 * Team Gerstenland
 * Created by Jürg Steudler
 *
 */

class Ranking {
    private int gameId;
    private String playerName;
    private int points;
    private int gameRank;
    private int endRank;

    /**
     * Default Konstruktor
     */
    public Ranking() {super();}

    /**
     * Initialisierung eines neuen Ranking Objekts mit Übergabe der definierten Parameter
     * @param gameId Eindeutige Spielerkennung
     * @param playerName Eindeutiger Spielername
     * @param points Anzahl Punkte
     * @param gameRank Rang während des Spiels
     * @param endRank Rang am Ende des Spiels
     */
    public Ranking(int gameId, String playerName, int points, int gameRank, int endRank) {
        this();
        this.gameId = gameId;
        this.playerName = playerName;
        this.points = points;
        this.gameRank = gameRank;
        this.endRank = endRank;
    }

    /** Getter und Setter der Klasse Ranking */

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGameRank() {
        return gameRank;
    }

    public void setGameRank(int gameRank) {
        this.gameRank = gameRank;
    }

    public int getEndRank() {
        return endRank;
    }

    public void setEndRank(int endRank) {
        this.endRank = endRank;
    }
}
