package ch.fhnw.atlantis.globalClasses.models;

import ch.fhnw.atlantis.globalClasses.interfaces.ITile;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoard {

    private HashMap<String, EnumSet<Tile>> hmTiles;

    public GameBoard () {
        int xpos = 0;
        int ypos = 0;
    }

    public void init() {
        this.hmTiles = TileFactory.getAllTiles();
        //getImageFromEnum();
    }

    /**
     * Erstellt ein Array von Strings mit allen Pfaden der Bilder für das Gameboard
     * @return Array mit Pfade der Bilser
     */
     public ITile[] getTilesToBoard() {
        ArrayList<String> returnPath = new ArrayList<>();
        for(EnumSet<Tile> tiles : this.hmTiles.values()) {
            returnPath.addAll(tiles.stream().map(Tile::getPath).collect(Collectors.toList()));
        }
        System.out.println(returnPath);
       //die untere Zeile generiert den folgenden Fehler "Caused by: java.lang.ArrayStoreException" --> Wie bringe ich diesen Fehler weg?
        return returnPath.toArray(new ITile[returnPath.size()]);
    }

    /**
     * Alternative Methode der oberen,
     * Er
     * @return
     */
    public ITile[] getTilesToBoard2() {
        ArrayList<ITile> returnPath = new ArrayList<>();
        for (EnumSet<Tile> tiles : this.hmTiles.values()) {
            for (Tile tile : tiles) {
               //returnPath.add(tile.getPath());
            }
        }
        return returnPath.toArray(new ITile[returnPath.size()]);
    }

    /**
     * Methode zum entfernen des Tile vom Board
     * @param tile
     * @return
     */
    public Tile removeTilesFromBoard(Tile tile) {
        //return TileFactory.getAllTiles().remove();
    return null;
    }
}
