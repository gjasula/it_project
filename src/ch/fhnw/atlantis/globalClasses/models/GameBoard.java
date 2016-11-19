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
        ArrayList<String> returnPath = new ArrayList<>();
        for(EnumSet<Tile> tiles : this.hmTiles.values()) {
            returnPath.addAll(tiles.stream().map(Tile::getPath).collect(Collectors.toList()));
        }
        System.out.println(returnPath);
        //ITile[] returnPath = Arrays.copyOf(this.hmTiles.values().toArray(), this.hmTiles.values().size(), ITile[].class);
        return returnPath.toArray(new ITile[returnPath.size()]);
    }

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
    public RandomSet() {
        int index = rand.nextInt(set.size());
        Iterator<Object> iter = set.iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
        }

    public Tile removeTilesFromBoard(Tile tile) {
        //return TileFactory.getAllTiles().remove();
    return null;
    }*/
}
