package ch.fhnw.atlantis.globalClasses;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoard {

    public static ArrayList<Tile>[] ArrayListArray;
    private ArrayList<Object>[] aLArray;

    private ArrayList<Tile> TilesA;
    private ArrayList<Tile> TilesB;

    private Array[] tilesAArray;

    private TileDeck tileDeck;
    private TileDeck waterTileDeck;


    public GameBoard () {

        tileDeck = new TileDeck();
        waterTileDeck = new TileDeck();

        tileDeck.createTileDeck();
        waterTileDeck.createWaterTileDeck();

        createGameBoardAL();

    }


    public void createGameBoardAL() {

     //  for (int i = 0; i < 55; i++) {
     //      ArrayListArray[i] = new ArrayList<>();
     //  }

     //   // Add Start to position 0
     //   aLArray[0].add(TileType.START);
     //   int i = 1;
//
     //   //10x2 Plättchen + 1 Wasserplättchen
     //   do {
     //       aLArray[i].add((tileDeck.remove(0)));
     //       aLArray[i].add((TilesA.remove(0)));
     //       aLArray[i].add((TileType.WATER));
     //       i++;
     //   } while (i > 0 && i < 11);
//
     //   //10x1 Plättchen + 1 Wasserplättchen
     //   do {
     //       aLArray[i].add((TilesA.remove(0)));
     //       aLArray[i].add((TileType.WATER));
     //       i++;
     //   } while (i > 10 && i < 21);
//
     //   //6x2 Plättchen + 1 Wasserplättchen
     //   do {
     //       aLArray[i].add((TilesA.remove(0)));
     //       aLArray[i].add((TilesA.remove(0)));
     //       aLArray[i].add((TileType.WATER));
     //       i++;
     //   } while (i > 20 && i < 27);
//
     //   //1 Wasserplättchen
     //   do {
     //       aLArray[i].add((aLArray[i].add((TileType.WATER))));
     //       i++;
     //   } while (i == 27);
//
     //   //6x2 Plättchen + 1 Wasserplättchen
     //   do {
     //       aLArray[i].add((TilesB.remove(0)));
     //       aLArray[i].add((TilesB.remove(0)));
     //       aLArray[i].add((aLArray[i].add((TileType.WATER))));
     //       i++;
     //   } while (i > 27 && i < 34);
//
     //   //10x1 Plättchen + 1 Wasserplättchen
     //   do {
     //       aLArray[i].add((TilesB.remove(0)));
     //       aLArray[i].add((aLArray[i].add((TileType.WATER))));
     //       i++;
     //   } while (i > 33 && i < 44);
//
     //   //10x2 Plättchen + 1 Wasserplättchen
     //   do {
     //       aLArray[i].add((TilesB.remove(0)));
     //       aLArray[i].add((TilesB.remove(0)));
     //       aLArray[i].add((aLArray[i].add((TileType.WATER))));
     //       i++;
     //   } while (i > 43 && i < 54);
//
     //   // Add End Tile to last position
     //   aLArray[54].add(TileType.END);
    }

    public TileDeck getTileDeck() {
        return tileDeck;
    }

    public void setTileDeck(TileDeck tileDeck) {
        this.tileDeck = tileDeck;
    }
}
