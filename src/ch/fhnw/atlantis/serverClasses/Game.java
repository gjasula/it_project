package ch.fhnw.atlantis.serverClasses;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * Team Gerstenland
 * Created by Jürg Steudler
 *
 */
public class Game implements Serializable {
    private static Game instance;

    private LocalDateTime gameStart;
    private int gameId;

    //Constructor
    private Game() {
        super();
    }

    /**
     * Instanziert ein neues Spiel
     *
     * @return Instance of the game
     */
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game ();
        }
        return instance;
    }

    /**
     * Gibt die Spiel ID zurück
     *
     * @return Game ID as Integer
     */
    public Integer getGameID() {return this.gameId;}




}
