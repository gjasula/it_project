package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.*;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.layout.*;

import javafx.scene.paint.Color;

import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class GameBoardView extends Application {

    private ArrayList<Player> players;
    private ArrayList<Card> pathCards;

    private HashMap<Integer, Label> scoresLabels;

    private BorderPane root;
    private GridPane gameBoard;

    private Stage stage;
    private Scene scene;

    private int maxColIndex, maxRowIndex, height;
    private Player localPlayer;
    private Tile consoleTile;

    //private GameBoardModel model = new GameBoardModel();


    /**
     * Mainmethode für Testzwecke
     * @throws FileNotFoundException
     */
    public static void main(String[] args) {

        Application.launch(args);
    }



    /**
     * Startmethode für Testzwecke
     * @throws FileNotFoundException
     */
    public void start(Stage primaryStage) throws FileNotFoundException {


        //Scene scene = new Scene();
        //primaryStage.setScene(scene);
        //primaryStage.show();
    }

    /**
     * Methode zum zeichnen der Tiles und Karten auf dem Spielbrett
     * @param pathCards: Arraylist mit allen Karten
     * @param tiles: Arraylist mit allen Bewegungskärtchen
     */
    private void drawCards(ArrayList<Card> pathCards, ArrayList<Tile> tiles) {

        for (Card card : pathCards) {
            for (Tile tile : tiles) {
                if (tile.getPathId() == 500) {
                    consoleTile = tile;
                }
                if (card.getPathID() == tile.getPathId()) {
                    card.setWidth(tile.getSide());
                    card.setHeight(tile.getSide());
                    card.setLayoutX(tile.getX());
                    card.setLayoutY(tile.getY());
                    card.setStroke(Color.BLACK);

                    addWater(card);

                    //addStartEndCard();

                    //card.addImagesToTile(model.htOfImages());
                    //TODO: At this place the card-image will be added to the card
                    //this.getChildren().add(card);
                }
            }
        }
    }

    /**
     * Methode zum zeichnen eines Wasserplättchen
     * @param card
     */
    private void addWater(Card card) {

        //card.setFill(new ImagePattern(model.htOfImages().get("water.jpg").getImage()));

    }

    /**
     * Methode zum zeichnen einet SPielfigur
     * TODO: Möglicherweise können wir hier unsere Symbole verwenden?
     */
    private void drawPawns() {
        int offsetX = 10;
        int offsetY = 5;
        for (Card card : pathCards) {
            // TileType Enum gibt noch einen Fehler da nicht public
            //if (card.getObject() == TileType.START) {
                for (Player player : players) {
                    for (Pawn pawn : player.getPawns()) {
                        //Put the game pieces onto the start field
                        pawn.setLayoutX(card.getLayoutX() + offsetX);
                        pawn.setLayoutY(card.getLayoutY() + offsetY);
                        pawn.setPathId(card.getPathID());
                        pawn.setFill(player.getColor());
                        pawn.setStroke(Color.BLACK);
                        pawn.setWidth(10);
                        pawn.setHeight(10);
                        //this.getChildren().add(pawn);
                        offsetX += 20;
                    }
                    offsetY += 15;
                    offsetX = 10;
                }
            }
        }
    }

    /** TODO: Alter Code zum löschen sobald alles funktioniert

     GridPane[][] gameBoard = new GridPane[COL][ROW];

     BorderPane bp = new BorderPane();

     @Override
     public void start(Stage primaryStage) throws FileNotFoundException {
     primaryStage.setTitle("GridPane example");

     //Adding GridPane
     GridPane gridPane = new GridPane();

     // 2D array of Buttons with value of 5,5
     ImageView[][] iV = new ImageView[5][5];

     for (String tiles : model.gameBoard.getPicturesToArraylist()) {
     for(int i=0; i<5; i++){
     for(int j=0; j<5;j++){

     //Initializing 2D buttons with values i,j
     iV[i][j] = new ImageView(ImageLoader.getImage("blue_1.jpg"));
     //iV[i][j] = new ImageView(ImageLoader.getImage(tiles));

     gridPane.add(iV[i][j], i, j);
     }
     }

     Scene scene = new Scene(gridPane,sceneWidth, sceneHeight);
     primaryStage.setScene(scene);
     primaryStage.show();
     }
     }

     GridPane gridPane;
     StackPane sp = new StackPane();
     Group root = new Group();
     Node node = new ImageView();

     ImageView iv = new ImageView();
     iv.setFitWidth(25);
     iv.setFitHeight(25);

     for (String tiles : model.gameBoard.getPicturesToArraylist()) {
     for (int i = 0; i < COL; i++) {
     for (int j = 0; j < ROW; j++) {
     gridPane = null;
     // create obstacle
     if (i == 1 && j == 1) {
     node = new ImageView(ImageLoader.getImage(tiles));
     }
     //add node to group
     if (iv != null) {
     root.getChildren().add(iv);
     // add to playfield for further reference using an array
     gameBoard[i][j] = gridPane;
     }
     }
     }
     }

     */

