package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.ImageLoader;
import ch.fhnw.atlantis.globalClasses.models.*;
import javafx.application.Application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;

import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class GameBoardView extends Pane {

    //private AtlantisView view;
    private ArrayList<Player> players;
    private ArrayList<Card> pathCards;


    private GridPane gameBoard;


    private int maxColIndex, maxRowIndex, height;
    private Player localPlayer;
    private Tile consoleTile;
    private HashMap<Integer, Label> scoresLabels;
    private Model model;

    // löschen



    private Scene scene;

    private BorderPane welcome_pane;
    private GridPane grid;
    private HBox buttonPane;
    private VBox labelPane;
    private HBox imagePane;

    private Button btnConnect;
    private Button btnAltConnect;
    private Button btnClose;

    private TextField IPEnter;

    private Label lbl1;
    private Label lbl2;
    private Label lbl3;
    private Label IPLabel;

    private ImageView root;

    private Label p1;
    private Label p2;
    private Label p3;
    private Label p4;

    private Label player1;
    private Label player2;
    private Label player3;
    private Label player4;



    /**
     * Constructer der GameModel Klasse
     * @param model

    public GameBoardView() {

        this.model = model;

        //ArrayList<Tile> tiles = setXYTiles(model.getTiles());
        //localPlayer = model.getLocalPlayer();
        //players = model.getPlayers();
        //pathCards = model.getPathCards();


//

        //drawCards(pathCards, tiles);

        //drawPawns();

        //createGameConsole();



//        gameBoard.setVgap(3);
  //      gameBoard.setHgap(3);

        root.setCenter(gameBoard);
        scene = new Scene(root);

        stage = new Stage();

    }*/
    public GameBoardView() {

        //  ------------------- Labels -------------------
        lbl1 = new Label();
        lbl1.setText("Willkommen in Atlantis");
        lbl2 = new Label();
        lbl2.setText("Bitte stellen Sie die Verbindung zum Server her");
        lbl3 = new Label();
        lbl3.setText("Team Gerstenland: IT-Projekt Fachhochschule Nordwestschweiz, 2016");




        // ------------------- Player Icons -------------------
        player1 = new Label("\ue7FD");
        grid.setConstraints(player1, 0, 0);
        grid.setHalignment(player1, HPos.CENTER);
        player2 = new Label("\ue7FD");
        grid.setConstraints(player2, 1, 0);
        grid.setHalignment(player2, HPos.CENTER);
        player3 = new Label("\ue7FD");
        grid.setConstraints(player3, 2, 0);
        grid.setHalignment(player3, HPos.CENTER);
        player4 = new Label("\ue7FD");
        grid.setConstraints(player4, 3, 0);
        grid.setHalignment(player4, HPos.CENTER);

        // ------------------- CSS den Icons zuweisen --> über Controller implementiert  ---------
        //player1.setId("Playerbefore");
        // player2.setId("Playerbefore");
        //  player3.setId("Playerbefore")
        //   player4.setId("Playerbefore");

        // ------------------- Player Labels definieren ---------
        p1 = new Label("Spieler 1");
        grid.setConstraints(p1, 0, 1);
        p2 = new Label("Spieler 2");
        grid.setConstraints(p2, 1, 1);
        p3 = new Label("Spieler 3");
        grid.setConstraints(p3, 2, 1);
        p4 = new Label("Spieler 4");
        grid.setConstraints(p4, 3, 1);
        grid.setConstraints(lbl3, 0, 3);
        grid.setColumnSpan(lbl3, 4);

        // ------------------- Gridpane definieren für Players-------------------


        gameBoard = new GridPane();
        gameBoard.setHgap(5);
        gameBoard.setVgap(5);

        gameBoard.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < 16; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPrefWidth(70);
            gameBoard.getColumnConstraints().add(cc);
        }
        for (int i = 0; i < 10; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setPrefHeight(70);
            gameBoard.getRowConstraints().add(rc);
        }

        gameBoard.setGridLinesVisible(true);

        // alle Inhalte ins Grid holen mit getChildren
        gameBoard.getChildren().addAll(player1, player2, player3, player4, p1, p2, p3, p4, lbl3);

        // ------------------- BorderPane erstellen und HBox, VBox, Grid hinzufügen -------------------
        BorderPane welcome_pane = new BorderPane();
        welcome_pane.setBottom(buttonPane);
        welcome_pane.setCenter(gameBoard);
        welcome_pane.setTop(labelPane);

        // ------------------- Stylesheets aufrufen -------------------
        welcome_pane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");
        welcome_pane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/font.css");

        // ------------------- BorderPane zu Scene hinzufügen und Fenstergrösse setzen -------------------
        scene = new Scene(welcome_pane, 1024, 640);
    }

    // ------------------- View der Stage bekannt geben -------------------
    public void show(Stage stage) {
        stage.setTitle("Atlantis by Team Gerstenland");
        stage.setResizable(false);                              // Fenstergrösse nicht veränderbar
        stage.setScene(scene);
        stage.show();
        // ------------------- Bild in Stage Titel laden  -------------------
        Image icon = new Image(getClass().getResourceAsStream("./../../resources/images/atlantis_client.jpg"));
        stage.getIcons().add(icon);

    }

    // ------------------- Getter Funktionen auf Element, für Interaktion -------------------
    //public Scene getScene() {
    //    return scene;
    //}

    public void setScene(Scene scene) {
        this.scene = scene;
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

                    //addWater(card);

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

        //card.setImage(new ImageView(new ImageLoader().getImage("./../../resources/images/water.jpg")));

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

