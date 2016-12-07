package ch.fhnw.atlantis.globalClasses.models;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by js on 06.12.2016.
 */
public class TileDeck {

    ArrayList<Tile> tileDeck = new ArrayList<>();
    ArrayList<Tile> watertileDeck = new ArrayList<>();

    /**
     *
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
            tileDeck.add(new Tile(i, Color.GREY));
        }
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.PINK));
        }
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.WHITE));
        }
        for (int i = 1; i < 8; i++) {
            tileDeck.add(new Tile(i, Color.YELLOW));
        }
        //Collections.shuffle(tileDeck);
        System.out.println(tileDeck);
    }

    public ArrayList<Tile> getTileDeck() {
        return tileDeck;
    }

    public void setTileDeck(ArrayList<Tile> tileDeck) {
        this.tileDeck = tileDeck;
    }

    public ArrayList<Tile> getWatertileDeck() {
        return watertileDeck;
    }

    public void setWatertileDeck(ArrayList<Tile> watertileDeck) {
        this.watertileDeck = watertileDeck;
    }
}
