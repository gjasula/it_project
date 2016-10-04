package ch.fhnw.atlantis.globalClasses.db;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Team Gerstenland
 * Created by Jürg Steudler
 *
 * Abstract:
 */

public class GameInfo {

    /** Spielerkennung **/
    public int GameId = 0;

    /** Startzeit des Spiels **/
    public LocalDateTime StartTime = LocalDateTime.MIN;

    /** Endzeit des Spiels **/
    public LocalDateTime EndTime = LocalDateTime.MAX;

    /** Liste der Spielernamen im Spiel **/
    public List<String> Players = new ArrayList<String>();

    /**
     * Default Constructor
     */
    public GameInfo() {
        super();
    }

    /**
     * Konstruktor zur Übergabe von parametrisierter Daten zu den allgemeinen Spielinformationen
     */
    public GameInfo(int gameId, LocalDateTime startTime, LocalDateTime endTime, String... players){
        this();
        this.GameId = gameId;
        this.StartTime = startTime;
        this.EndTime = endTime;
        for (String player : players) {
            this.Players.add(player);
        }
    }
}
