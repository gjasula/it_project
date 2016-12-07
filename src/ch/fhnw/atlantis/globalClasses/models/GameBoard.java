package ch.fhnw.atlantis.globalClasses.models;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoard {

    public static ArrayList<Object>[] aLArray;

    private ArrayList<Tile> TilesA;
    private ArrayList<Tile> TilesB;

    private Array[] tilesAArray;



    public GameBoard () {
        init();

    }

    public void init() {
        //createGameBoardArrayList();

    }
}

    /**
     * TODO: Löschen sobald es anderweitig funktioniert
     *
     * Erstellt ein Array von Strings mit allen Pfaden der Bilder für das Gameboard
     * @return Array mit Pfade der Bilder

    public String[] getPicturesToArraylist() {
        ArrayList<String> returnPath = new ArrayList<>();
        for(EnumSet<Tile_Old> tileOlds : this.hmTilesA.values()) {
            returnPath.addAll(tileOlds.stream().map(Tile_Old::getPath).collect(Collectors.toList()));
        }
        System.out.println(returnPath);
        //die untere Zeile generiert den folgenden Fehler "Caused by: java.lang.ArrayStoreException" --> Wie bringe ich diesen Fehler weg?
        return returnPath.toArray(new String[returnPath.size()]);
    }


    /**
     * Methode zum entfernen des Tile_Old vom Board
     * @param tileOld
     * @return

    public Tile_Old removeTilesFromBoard(Tile_Old tileOld) {
        //return TileFactory.getAllTiles().remove();
    return null;
    }*/
