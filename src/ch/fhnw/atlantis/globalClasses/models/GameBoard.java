package ch.fhnw.atlantis.globalClasses.models;

import ch.fhnw.atlantis.globalClasses.interfaces.ITile;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoard {

    private HashMap<String, EnumSet<Tile>> htTiles;


    public GameBoard () {
        int xpos = 0;
        int ypos = 0;


    }

    public void init() {
        this.htTiles = TileFactory.getAllTiles();
        //getImageFromEnum();

    }

    /**
     * Bringt alle Enums der Klasse Tile in eine Arrayliste
     * Shuffle
     * @return
     */
    public ArrayList<String> getImageFromEnum(){
        //htTiles.values().toArray(new Tile[0]);
        ArrayList<String> values = new ArrayList<>();
        for (Tile e : Tile.values()) {
            values.add(e.getPath());
            //List<Tile> tiles = new ArrayList<>();
            Collections.addAll(values);
            Collections.shuffle(values);
           System.out.print(e.getPath());
            //tiles.add(int l, );

        }
        return values;
    }

    public ITile[] getTilesToBoard() {
        ITile[] returnPath = Arrays.copyOf(this.htTiles.values().toArray(), this.htTiles.values().size(), ITile[].class);
                return returnPath;
    }

    /**
    public Tile removeTilesFromBoard(Tile tile) {
        //return TileFactory.getAllTiles().remove();
    return null;
    }*/
}
