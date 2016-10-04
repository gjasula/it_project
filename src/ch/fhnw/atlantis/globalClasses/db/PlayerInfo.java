package ch.fhnw.atlantis.globalClasses.db;

/**
 * Created by js on 04.10.2016.
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
