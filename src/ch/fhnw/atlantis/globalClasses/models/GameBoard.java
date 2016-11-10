package ch.fhnw.atlantis.globalClasses.models;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoard {

    HashMap<String, EnumSet<?>> htTiles;


    public GameBoard () {
        int xpos = 0;
        int ypos = 0;

    }

    public void init() {
        this.htTiles = TileFactory.getAllTiles();

    }

    /**
     * Bringt alle Enums der Klasse Tile in einen Hashset
     * Shuffle
     * @return
     */
    public static ArrayList<String> getImagePath() throws FileNotFoundException {

        ArrayList<String> values = new ArrayList<>();
        for (Tile e : Tile.values()) {
            values.add(e.getPath());
            List<Tile> tiles = new ArrayList<>();
            Collections.addAll(tiles, Tile.values());
            Collections.shuffle(tiles);
           // System.out.print(getImage(e.getPath()));
            //tiles.add(int l, );

        }
        return values;
    }

    /**
     * Methode zum Laden einer Image Resource
     * @param imageName
     * @return
     * @throws FileNotFoundException
     */

    public static Image getImage(String imageName) throws FileNotFoundException {
        // Implemetierung des ServiceLocators (siehe Projekt nicht lustig)
        File file = new File("resources/"+ imageName);
        if (!file.exists()) {
            // ServiceLocator
            throw new FileNotFoundException(imageName+" konnte nicht gefunden werden");
        }
        try {
            return new Image(file.getAbsolutePath());
        } catch (Exception e) {
            //ServiceLocator abfangen
        }
        return null;
    }


    public Tile removeTilesFromBoard(Tile tile) {
        //return TileFactory.getAllTiles().remove();
    return null;
    }


}
