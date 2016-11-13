package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.GameBoard;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoardModel {

    public GameBoard gameBoard = new GameBoard();

    //protected ObservableList<Hashtable> allTiles = FXCollections.observableList();

    public GameBoardModel() {
        //allTiles.addAll(TileFactory.getAllTiles());

        gameBoard.init();
        //this.player = player;
    }


}
