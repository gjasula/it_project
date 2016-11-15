package ch.fhnw.atlantis.globalClasses.models;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by js on 02.11.2016.
 */
public class TileFactory {

    /**
     * Erstellt eine Hashtable mit einer Arraylist und mischt diese
     * @return Hashtable with all Tiles
     */
    public static HashMap<String, EnumSet<Tile>> getAllTiles() {

        HashMap<String, EnumSet<Tile>> htAllTiles = new HashMap<>();
        //htAllTiles.put("Tiles", EnumSet.allOf(Tile.class));
        for (Map.Entry<String, EnumSet<Tile>> e : htAllTiles.entrySet()) {


        }
        System.out.println(htAllTiles);
        return htAllTiles;
    }

}

