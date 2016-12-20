package ch.fhnw.atlantis.globalClasses.models;

/**
 * Created by juerg on 07.12.2016.
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tobias on 02.11.2016 (if not written by Tobias, it is mentioned)
 *
 * Creates all the ArrayLists for the Tiledeck (relevant tiles), the Watertiles and the played tiles (tiles out of the game)
 * Contains methods that create the tile objects and put them into the respective ArrayList
 */
public class TileDeck {

    ArrayList<Tile> tileDeck = new ArrayList<Tile>(); //contains all the 42 tiles that are from relevance (no water)
    ArrayList<Tile> waterTilesDeck = new ArrayList<Tile>(); //stores 42 watertiles
    static ArrayList<String> tileDeckString = new ArrayList<>();
    static int PositionPlayer1 = -1;
    static int PositionPlayer2 = -1;
    static int LastPathTile;

    /**
     * creates ArrayList with all tiles that have a color and a number (no watertiles)
     */
    public void createTileDeck() {
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.BLUE));
        }
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.BROWN));
        }
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.GREEN));
        }
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.GRAY));
        }
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.PINK));
        }
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.WHITE));
        }
        for (int i = 1; i < 8;  i++) {
            tileDeck.add(new Tile(i, Color.YELLOW));
        }
        Collections.shuffle(tileDeck);
    }

    /**
     * creates ArrayList with 42 watertiles in it
     */
    public void createWaterTileDeck() {
        for (int i = 1; i <= 42; i++) { //42 as random, could be more or also less, but to be safe 42 tiles
            waterTilesDeck.add(new Tile(true));
        }
    }

    public String getTileImage(){

        String nextTile = null;

        nextTile = tileDeckString.get(0);
        tileDeckString.remove(0);

        return nextTile;
    }

    public String getGameBoard(){
        String GameBoard = "";

        for( int i = 0 ; i < tileDeckString.size() ; i++ )
        {
            //System.out.println(PlayerOneHandCards.get(i));
            GameBoard += tileDeckString.get(i) + ",";
        }

        return GameBoard;
    }

    public void generateTileDeck(){

        for( int i = 1 ; i < 8 ; i++ ) {
            String add = "blue_"+i+".jpg";
            tileDeckString.add(add);
        }
        for( int i = 1 ; i < 8 ; i++ ) {
            String add = "brown_"+i+".jpg";
            tileDeckString.add(add);
        }
        for( int i = 1 ; i < 8 ; i++ ) {
            String add = "green_"+i+".jpg";
            tileDeckString.add(add);
        }
        for( int i = 1 ; i < 8 ; i++ ) {
            String add = "grey_"+i+".jpg";
            tileDeckString.add(add);
        }
        for( int i = 1 ; i < 8 ; i++ ) {
            String add = "pink_"+i+".jpg";
            tileDeckString.add(add);
        }
        for( int i = 1 ; i < 8 ; i++ ) {
            String add = "white_"+i+".jpg";
            tileDeckString.add(add);
        }
        for( int i = 1 ; i < 8 ; i++ ) {
            String add = "yellow_"+i+".jpg";
            tileDeckString.add(add);
        }

        Collections.shuffle(tileDeckString);
        // Reduce PathTiles to 25
        tileDeckString.subList(25, 49).clear();
    }

    public String getPositionXY(int Player ,String MovementCard){
        String PathTile = null;
        String Position = "Position_NotAvailable";

        switch (MovementCard) {
            case "MV_Blue":
                PathTile = "blue";
                break;
            case "MV_Brown":
                PathTile = "brown";
                break;
            case "MV_Green":
                PathTile = "green";
                break;
            case "MV_Grey":
                PathTile = "grey";
                break;
            case "MV_Pink":
                PathTile = "pink";
                break;
            case "MV_White":
                PathTile = "white";
                break;
            case "MV_Yellow":
                PathTile = "yellow";
                break;
            default:
        }

        // Richard - Erkennt welches das Letzte Wegplättchen ist.
        for (int i = 0; i < tileDeckString.size(); i++){
            if(tileDeckString.get(i).equals("water.jpg")){
            }else{
                LastPathTile = i;
            }
            //System.out.println("Das letzte Wegplättchen ist auf Position: "+LastPathTile);
        }

        if(Player == 1) {
            // Richy - returns position of first which fits MVCard
            PositionPlayer1++;
            for (int i = PositionPlayer1; i < tileDeckString.size(); i++) {
                if (tileDeckString.get(i).startsWith(PathTile)) {
                    Position = "Position_" + i;
                    PositionPlayer1 = i;
                    if(PositionPlayer1 == LastPathTile){
                        Position = "Position_98";
                        break;
                    }
                    break;
                }
            }
        }
        else if(Player == 2) {
            // Richy - returns position of first which fits MVCard
            PositionPlayer2++;
            for (int i = PositionPlayer2; i < tileDeckString.size(); i++) {
                if (tileDeckString.get(i).startsWith(PathTile)) {
                    Position = "Position_" + i;
                    PositionPlayer2 = i;
                    break;
                }
            }
        }
        return Position;
    }

    public ArrayList<Tile> getTiles() {
        return tileDeck;
    }

    public ArrayList<Tile> getWaterTiles() {
        return waterTilesDeck;
    }

    public int getNumberOfTilesInDeck() {
        return tileDeck.size();
    }

    public int getNumberOfWaterTilesInDeck() {
        return waterTilesDeck.size();
    }
}
