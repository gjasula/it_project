package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.Card;
import ch.fhnw.atlantis.globalClasses.models.GameBoard;
import ch.fhnw.atlantis.globalClasses.models.Player;
import ch.fhnw.atlantis.globalClasses.models.Tile;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by js on 02.11.2016.
 */
public class GameBoardModel {

    private ArrayList<Player> players;
    private ArrayList<Tile> tiles;
    private ArrayList<Card> pathCards;
    private ArrayList<Card> deck;
    private Player localPlayer;

    private Hashtable<String, ImageView> htOfImages;

    public GameBoard gameBoard = new GameBoard();

    //protected ObservableList<Hashtable> allTiles = FXCollections.observableList();

    public GameBoardModel(Player localPlayer) {

        for (Player player : players) {
            player.playerColor();
            if (player.getPlayerID() == localPlayer.getPlayerID()) {
                this.localPlayer = player;
            }
        }
    }

}