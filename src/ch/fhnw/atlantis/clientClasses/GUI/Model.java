package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Nadine on 03.11.2016.
 * ch.fhnw.atlantis.clientClasses.GUI.Model: speichert die wichtigen Elemente des Programms
 *
 * PrimaryStage ist das Hauptanwendungsfenster -
 * braucht es um versch. Views anzuzeigen (damit Fenster nicht immer auf und zu geht merkt sich Programm "PrimaryStage")
 * PrimaryStage intern werden die Views durch neue Views ersetzt.
 */

public class Model {
    private Stage primaryStage = null;

    private TileDeck tileDeck;

    private ArrayList<Player> players;
    private ArrayList<Tile> tiles;
    private ArrayList<Card> pathCards;
    private ArrayList<Card> deck;
    private Player localPlayer;

    private Hashtable<String, ImageView> htOfImages;

    public GameBoard gameBoard = new GameBoard();

    public Model(Stage primaryStage){

        tileDeck = new TileDeck();

        // to be deleted?
        //tileDeck.createTileDeck();

        // Richy's generateTileDeck
        //tileDeck.generateTileDeck();

        this.primaryStage = primaryStage;
    }

    // Getter and Setter

    public Stage getPrimaryStage(){
        return primaryStage;
    }
}


