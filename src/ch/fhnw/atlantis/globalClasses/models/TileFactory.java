package ch.fhnw.atlantis.globalClasses.models;

import ch.fhnw.atlantis.globalClasses.interfaces.ITile;

import java.util.*;

/**
 * Created by js on 02.11.2016.
 */
public class TileFactory {

    /**
     * Erstellt eine Hashmap mit allen Tile
     * @return Hashtable with all Tiles
     */
    public static HashMap<String, EnumSet<Tile>> getAllTiles() {
        HashMap<String, EnumSet<Tile>> hmAllTiles = new HashMap<>();
        hmAllTiles.put("Tiles", EnumSet.allOf(Tile.class));
        System.out.println(hmAllTiles);
        return hmAllTiles;
    }


    /**
     * Alternative Methode zur oberen
     * Bringt alle Enums der Klasse Tile in eine Arrayliste
     * Shuffle
     * @return
     */
    //Alternative Variante mit ArrayListe
    public ArrayList<Tile> getTilesToArrayList(){
        //htTiles.values().toArray(new Tile[0]);
        ArrayList<Tile> values = new ArrayList<>();
        for (Tile e : Tile.values()) {
            values.add(e);

            //Collections.addAll(values);
            Collections.shuffle(values);
            System.out.print(e.getPath());
        }
        return values;
    }
}

