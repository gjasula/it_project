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
    static ArrayList<String> PlayerOneHandCards = new ArrayList<>();
    static ArrayList<String> PlayerTwoHandCards = new ArrayList<>();

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

    // Austausch von Wegplättchen in Bewegungskarte
    static void ChangeTileToMovementcard(int Player, int TileID){

        int PullCards;

        for (Tile PathTile : Tile.values())
        {
            if(TileID == PathTile.getId()){
                // Das abrunden laut Spielregeln nicht nötig, da im enum keine Kommastellen vorahnden sind
                PullCards = PathTile.getValue() / 2;
                getCardFromStack(PullCards, Player);
            }
        }
    }

    //Remove Card from hand
    //removeCardFromHand(1, 1);
    static void removeCardFromHand(int Player, int Card){

        if(Player == 1){
            PlayerOneHandCards.remove(Card);
            for( int i = 0 ; i < PlayerOneHandCards.size() ; i++ )
            {
                System.out.println(PlayerOneHandCards.get(i));
            }
        }else{
            PlayerTwoHandCards.remove(Card);
            for( int i = 0 ; i < PlayerTwoHandCards.size() ; i++ )
            {
                System.out.println(PlayerTwoHandCards.get(i));
            }
        }

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

    static void getCardFromStack(int AmountMV, int Player){
        // Ausgabe erste Karte vom Stapel
        for( int i = 0 ; i < AmountMV ; i++ )
        {
            if(Player == 1){
                PlayerOneHandCards.add(MovementCards.get(0));
            }else{
                PlayerTwoHandCards.add(MovementCards.get(0));
            }
            MovementCards.remove(0);
        }

    }
}
