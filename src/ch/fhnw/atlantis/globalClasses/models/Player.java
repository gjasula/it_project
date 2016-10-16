package ch.fhnw.atlantis.globalClasses.models;
import java.util.ArrayList;
import java.util.Collections;
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
    static ArrayList<String> MovementCards = new ArrayList<>();

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

        // Um danach den Spielern Karten zuzuweisen getCardFromStack(AnzahlKarten)
    }

    /*
     * Kartenstapel erzeugen - Richard Künzi
     */
    static void CardStack(){
        String MV_Blue = "MV_Blue";
        String MV_Brown = "MV_Brown";
        String MV_Green = "MV_Green";
        String MV_Grey = "MV_Grey";
        String MV_Pink = "MV_Pink";
        String MV_White = "MV_White";
        String MV_Yellow = "MV_Yellow";

        // Alle 105 Bewegungskarten einfügen (15 mal werden die 7 Karten hinzugefügt)
        for( int i = 0 ; i < 15 ; i++ )
        {
            MovementCards.add(MV_Blue);
            MovementCards.add(MV_Brown);
            MovementCards.add(MV_Green);
            MovementCards.add(MV_Grey);
            MovementCards.add(MV_Pink);
            MovementCards.add(MV_White);
            MovementCards.add(MV_Yellow);
        }
        // Mischen der Bewegungskarten
        Collections.shuffle(MovementCards);
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

    static void getCardFromStack(int AmountMV){
        // Ausgabe erste Karte vom Stapel
        for( int i = 0 ; i < AmountMV ; i++ )
        {
            System.out.println(MovementCards.get(0));
            MovementCards.remove(0);
        }

    }
}
