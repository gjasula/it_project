package ch.fhnw.atlantis.globalClasses.models;

import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by juerg on 02.12.2016.
 *
 * Erstellung eines Player
 */

public class Player implements Serializable {

    //private static final long serialVersionUID = 1;

    private ArrayList<Pawn> pawns;
    private ArrayList<Card> movementCards;
    private String playerName;
    private String gameName;
    private int playerID;
    private Color color;
    private int bridge;
    private int score;
    private Pawn pawn, pawn1, pawn2, pawn3;

    private boolean isConnected = true;
    public static int playernumber = 0;
    static Stack<String> MovementCards = new Stack<String>();
    static ArrayList<String> PlayerOneHandCards = new ArrayList<>();
    static ArrayList<String> PlayerTwoHandCards = new ArrayList<>();

    public Player(int playerID, String gameName, String playerName) {
        this.playerName = playerName;
        this.playerID = playerID;
        this.gameName = gameName;

        pawn1 = new Pawn(this, 1);
        pawn2 = new Pawn(this, 2);
        pawn3 = new Pawn(this, 3);

    }

    public Player() {

    }

    /**
     * Methode zur Vergabe einer Farbe an einen Player
     */
    //public playerColor(Color color) {
    //    switch (playerID) {
    //        case 0:
    //            color = Color.RED;
    //            break;
    //        case 1:
    //            color = Color.BLUE;
    //            break;
    //        case 2:
    //            color = Color.GREEN;
    //            break;
    //        case 3:
    //            color = Color.YELLOW;
    //            break;
    //    }
    //    return color;
    //}

    // TODO: müsste man noch auf die neue Tiles Klasse anpassen
    // Austausch von Wegplättchen in Bewegungskarte
    static void ChangeTileToMovementcard(int Player, int TileID){

        int PullCards;

        //for (Tile pathTile : Tile.values())
        //{
        //    if(TileID == pathTile.getId()){
        //        // Das abrunden laut Spielregeln nicht nötig, da im enum keine Kommastellen vorahnden sind
        //        PullCards = pathTile.getValue() / 2;
        //        getCardFromStack(PullCards, Player);
        //    }
        //}
    }

    // Jedem Spieler wird eine ID zugewiesen welcher für die Identifikation genutzt wird. - Richard Künzi
    public int definePlayerIdentity(){
        switch (playernumber) {
            case 2:
                playernumber++;
                break;
            case 3:
                playernumber++;
                break;
            case 4:
                playernumber++;
                break;
            default:
                playernumber++;
        }
        return playernumber;
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
            MovementCards.push(MV_Blue);
            MovementCards.push(MV_Brown);
            MovementCards.push(MV_Green);
            MovementCards.push(MV_Grey);
            MovementCards.push(MV_Pink);
            MovementCards.push(MV_White);
            MovementCards.push(MV_Yellow);
        }
        // Mischen der Bewegungskarten
        Collections.shuffle(MovementCards);
    }

    public Color getColor() { return color; }

    public int getScore() { return score; }

    public int getBridge() {
        return bridge;
    }

    public void removeBridge() {
        this.bridge = 0;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void subtractScore(int score) {
        this.score -= score;
    }

    public ArrayList<Pawn> getPawns() {
        return pawns;
    }

    public ArrayList<Card> getMovementCards() { return movementCards; }

    static void getCardFromStack(int AmountMV, int Player){
        // Ausgabe erste Karte vom Stapel
        for( int i = 0 ; i < AmountMV ; i++ )
        {
            if(Player == 1){
                PlayerOneHandCards.add(MovementCards.pop());
            }else{
                PlayerTwoHandCards.add(MovementCards.pop());
            }
            MovementCards.remove(0);
        }
    }

    /**
     * Getter für Nummerierung der Spielfiguren
     * @param pawn ist eine Spielfigutr
     * @return die jeweilige Spielfigur
     */
    public Pawn getPawn(Pawn pawn) {
        if (pawn.getPawnNum() == 1) {
            return pawn1;
        } else if (pawn.getPawnNum() == 2) {
            return pawn2;
        } else if (pawn.getPawnNum() == 3) {
            return pawn3;
        }
        return null;
    }

}
