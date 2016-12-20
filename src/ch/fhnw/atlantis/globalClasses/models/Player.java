package ch.fhnw.atlantis.globalClasses.models;

import ch.fhnw.atlantis.clientClasses.GUI.Interpreter;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public static int GameStarted = 0;
    public static int PlayerOnePawnOnLand = 0;
    public static int PlayerTwoPawnOnLand = 0;
    static ArrayList<String> MovementCards = new ArrayList<>();
    static ArrayList<String> PlayerOneHandCards = new ArrayList<>();
    static ArrayList<String> PlayerTwoHandCards = new ArrayList<>();
    static List<String> PlayerOneHandTiles = new ArrayList<>();
    static List<String> PlayerTwoHandTiles = new ArrayList<>();

    public Player(int playerID, String gameName, String playerName) {
        this.playerName = playerName;
        this.playerID = playerID;
        this.gameName = gameName;

        pawn1 = new Pawn(this, 1);
        pawn2 = new Pawn(this, 2);
        pawn3 = new Pawn(this, 3);

    }

    // Required for interpreter on server
    public Player(){}

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

    // Remove Card from hand
    // removeCardFromHand(1, 1);
    // Richard Künzi
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

    public void removeMovementCardFromHand(int Player, String MovementCard){
        if(Player == 1) {
            // Kein simples .remove, da sonst alle elemente aus der Liste gelöscht werden
            for (int i = 0; i < PlayerOneHandCards.size(); i++) {
                if(PlayerOneHandCards.get(i).equals(MovementCard)){
                    PlayerOneHandCards.remove(i);
                    break;
                }
            }
        }else if(Player == 2){
            PlayerTwoHandCards.remove(MovementCard);
        }

    }

    public void GameStart(){
        TileDeck tileDeck = new TileDeck();
        if(GameStarted == 0){
            // MovementCard Stapel erzeugen
            CardStack();
            tileDeck.generateTileDeck();
        GameStarted = 1;
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
        getCardFromStack(20,1); // For Testing 20 back to 4!!
        getCardFromStack(5,2);
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

    public String getPlayerOneHand(){
        String StringPlayerOneHandCards = "";

        for( int i = 0 ; i < PlayerOneHandCards.size() ; i++ )
        {
            //System.out.println(PlayerOneHandCards.get(i));
            StringPlayerOneHandCards += PlayerOneHandCards.get(i) + ",";
        }
        return StringPlayerOneHandCards;
    }

    public String getPlayerTwoHand(){
        String StringPlayerTwoHandCards = "";

        for( int i = 0 ; i < PlayerTwoHandCards.size() ; i++ )
        {
            //System.out.println(PlayerOneHandCards.get(i));
            StringPlayerTwoHandCards += PlayerTwoHandCards.get(i) + ",";
        }
        return StringPlayerTwoHandCards;
    }

    public String getPlayerHandTiles(int Player){
        String StringPlayerHandTiles = "";

        if(Player == 1){
            for( int i = 0 ; i < PlayerOneHandTiles.size() ; i++ )
            {
                //System.out.println(PlayerOneHandCards.get(i));
                StringPlayerHandTiles += PlayerOneHandTiles.get(i) + ",";
            }
        }else if(Player == 2){
            for( int i = 0 ; i < PlayerTwoHandTiles.size() ; i++ )
            {
                //System.out.println(PlayerOneHandCards.get(i));
                StringPlayerHandTiles += PlayerTwoHandTiles.get(i) + ",";
            }
        }
        return StringPlayerHandTiles;
    }

    public void setPawnOnLand(int Player){
        if(Player == 1) {
            PlayerOnePawnOnLand++;

            if(PlayerOnePawnOnLand == 3){
                // Leite Spielschluss ein
            }
        }else if(Player == 2){
            PlayerTwoPawnOnLand++;
            if(PlayerTwoPawnOnLand == 3){
                // Leite Spielschluss ein
            }
        }
    }

    public void updatePlayerHandTiles(int Player, String Position){
        int PickUpTile;
        TileDeck tileDeck = new TileDeck();

        // Die 0 muss mit Gänsefüsslein sein, weil es ein String ist!
        if(Position.equals("0")){
            System.out.println("Position is 0, no Tile for Player");

        // User is on last PathTile
        }else if(Position.equals("98")){
            PickUpTile = tileDeck.LastPathTile;
            if (Player == 1) {
                PlayerOneHandTiles.add(tileDeck.tileDeckString.get(PickUpTile));
                tileDeck.tileDeckString.set(PickUpTile, "water.jpg");
                setPawnOnLand(1);
                tileDeck.PositionPlayer1 = -1;
            } else if (Player == 2) {
                PlayerTwoHandTiles.add(tileDeck.tileDeckString.get(PickUpTile));
                tileDeck.tileDeckString.set(PickUpTile, "water.jpg");
                setPawnOnLand(2);
                tileDeck.PositionPlayer2 = -1;
            }

        // User lands on any PathTile
        }else{
            PickUpTile = Integer.parseInt(Position) - 1;
            System.out.println(Position+" "+PickUpTile);
            if (Player == 1) {
                PlayerOneHandTiles.add(tileDeck.tileDeckString.get(PickUpTile));
                tileDeck.tileDeckString.set(PickUpTile, "water.jpg");
            } else if (Player == 2) {
                PlayerTwoHandTiles.add(tileDeck.tileDeckString.get(PickUpTile));
                tileDeck.tileDeckString.set(PickUpTile, "water.jpg");
            }
        }
    }


    public static String getCardFromStack(int AmountMV, int Player){
        String returnToClient = MovementCards.get(0);

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
        System.out.println("Player One Hand: " + PlayerOneHandCards);
        System.out.println("Player Two Hand: " + PlayerTwoHandCards);

        return returnToClient;
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
