package ch.fhnw.atlantis.globalClasses.models;

import java.io.Serializable;

/**
 *
 * Team Gerstenland
 * Created by Jürg Steudler
 *
 */

public class Player implements Serializable {
    private String playername;
    private boolean isConnected = true;
    private int playernumber = 0;

    /**
     * Default Konstruktor
     */
    public Player() {super();}

    /**
     * Instanzierung eines neuen Spielers
     */
    public Player(String playername){
        this();
        this.playername = playername;
    }

    /** Getter und Setter der Player Klasse **/
    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public int getPlayernumber() {
        return playernumber;
    }

    public void setPlayernumber(int playernumber) {
        this.playernumber = playernumber;
    }
}
