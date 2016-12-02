package ch.fhnw.atlantis.globalClasses.models;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoard {

    public GameBoard () {

    }

    public void init() {
        createGameBoard();

    }

    public void createGameBoard() {

    }

    /**
    public void createGameBoard() {

        for (int i = 0; i < 55; i++) {
            ArrayListArray[i] = new ArrayList<>();
        }
        //int atlantis;
        ArrayListArray[0].add(water);
        int i = 1;


        //10x2 Plättchen + 1 Wasserplättchen
        do {
            ArrayListArray[i].add((hmTiles.remove(0)));
            ArrayListArray[i].add((TilesA.tilesAArray.remove(0)));
            ArrayListArray[i].add((WaterTiles.WaterTilesArray.remove(0)));
            i++;
        } while (i > 0 && i < 11);

        //10x1 Plättchen + 1 Wasserplättchen
        do {
            ArrayListArray[i].add((TilesA.tilesAArray.remove(0)));
            ArrayListArray[i].add((WaterTiles.WaterTilesArray.remove(0)));
            i++;
        } while (i > 10 && i < 21);

        //6x2 Plättchen + 1 Wasserplättchen
        do {
            ArrayListArray[i].add((TilesA.tilesAArray.remove(0)));
            ArrayListArray[i].add((TilesA.tilesAArray.remove(0)));
            ArrayListArray[i].add((WaterTiles.WaterTilesArray.remove(0)));
            i++;
        } while (i > 20 && i < 27);

        //1 Wasserplättchen
        do {

            ArrayListArray[i].add((WaterTiles.WaterTilesArray.remove(0)));
            i++;
        } while (i == 27);

        //6x2 Plättchen + 1 Wasserplättchen
        do {
            ArrayListArray[i].add((TilesB.tilesBArray.remove(0)));
            ArrayListArray[i].add((TilesB.tilesBArray.remove(0)));
            ArrayListArray[i].add((WaterTiles.WaterTilesArray.remove(0)));
            i++;
        } while (i > 27 && i < 34);

        //10x1 Plättchen + 1 Wasserplättchen
        do {
            ArrayListArray[i].add((TilesB.tilesBArray.remove(0)));
            ArrayListArray[i].add((WaterTiles.WaterTilesArray.remove(0)));
            i++;
        } while (i > 33 && i < 44);

        //10x2 Plättchen + 1 Wasserplättchen
        do {
            ArrayListArray[i].add((TilesB.tilesBArray.remove(0)));
            ArrayListArray[i].add((TilesB.tilesBArray.remove(0)));
            ArrayListArray[i].add((WaterTiles.WaterTilesArray.remove(0)));
            i++;
        } while (i > 43 && i < 54);

        ArrayListArray[54].add(land);
    }*/


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

}
