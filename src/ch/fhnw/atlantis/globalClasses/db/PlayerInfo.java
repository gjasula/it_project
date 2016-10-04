package ch.fhnw.atlantis.globalClasses.db;

/**
 *
 * Team Gerstenland
 * Created by Jürg Steudler
 *
 */

public class PlayerInfo {
    /** Spielername **/
    public String PlayerName;

    /**
     * Default Konstruktor
     */
    public PlayerInfo() {super();}

    /**
     * Initialisiert ein neues Spielerobjekt und übergiebt die Parameter
     */
    public PlayerInfo(String playerName){
        this();
        this.PlayerName = playerName;
    }
}
