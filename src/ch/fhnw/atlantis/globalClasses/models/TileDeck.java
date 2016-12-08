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
        System.out.println(tileDeck);
    }

    /**
     * creates ArrayList with 42 watertiles in it
     */
    public void createWaterTileDeck() {
        for (int i = 1; i <= 42; i++) { //42 as random, could be more or also less, but to be safe 42 tiles
            waterTilesDeck.add(new Tile(true));
        }
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
