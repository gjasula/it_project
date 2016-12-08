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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class GameBoardView extends Pane {

    private Array[] LabelsArray;
    //private AtlantisView view;
    private ArrayList<Player> players;
    private ArrayList<Card> pathCards;


    private GridPane gameBoard;
    private GridPane grid;
    private Scene scene;


    private int maxColIndex, maxRowIndex, height;
    private Player localPlayer;
    private Tile consoleTile;
    private HashMap<Integer, Label> scoresLabels;
    private Model model;

    // löschen

    private BorderPane welcome_pane;
    private HBox buttonPane;
    private VBox labelPane;
    private HBox imagePane;

    private Button finishTurn;
    private Button buyCard;
    private Button btnClose;

    private TextField IPEnter;

    private ImageView root;

    private Label p1;
    private Label p2;
    private Label p3;
    private Label p4;

    private Label player1;
    private Label player2;
    private Label player3;
    private Label player4;

    private Label pointsP1;
    private Label pointsP2;
    private Label pointsP3;
    private Label pointsP4;

    public GameBoardView() {



        // ------------------- Grid für Player Icons -------------------
        grid = new GridPane();

        grid.setPadding(new Insets(20, 50, 20, 70));
        grid.setVgap(10);
        grid.setHgap(60);
        grid.setGridLinesVisible(false);

        // ------------------- Player Icons -------------------
        player1 = new Label("\ue7FD");
        grid.setConstraints(player1, 0, 0);
        grid.setHalignment(player1, HPos.CENTER);
        pointsP1 = new Label("0");
        grid.setConstraints(pointsP1, 1, 0 );
        grid.setHalignment(pointsP1, HPos.CENTER);

        player2 = new Label("\ue7FD");
        grid.setConstraints(player2, 2, 0);
        grid.setHalignment(player2, HPos.CENTER);
        pointsP2 = new Label("0");
        grid.setConstraints(pointsP2, 3, 0 );
        grid.setHalignment(pointsP2, HPos.CENTER);

        player3 = new Label("\ue7FD");
        grid.setConstraints(player3, 4, 0);
        grid.setHalignment(player3, HPos.CENTER);
        pointsP3 = new Label("0");
        grid.setConstraints(pointsP3, 5, 0 );
        grid.setHalignment(pointsP3, HPos.CENTER);

        player4 = new Label("\ue7FD");
        grid.setConstraints(player4, 6, 0);
        grid.setHalignment(player4, HPos.CENTER);
        pointsP4 = new Label("0");
        grid.setConstraints(pointsP4, 7, 0 );
        grid.setHalignment(pointsP4, HPos.CENTER);

        // ------------------- CSS den Icons zuweisen --> über Controller implementiert  ---------
        //player1.setId("Playerbefore");
        // player2.setId("Playerbefore");
        //  player3.setId("Playerbefore")
        //   player4.setId("Playerbefore");

        // ------------------- Player Labels definieren ---------
        p1 = new Label("Spieler 1");
        grid.setConstraints(p1, 0, 1);

        p2 = new Label("Spieler 2");
        grid.setConstraints(p2, 2, 1);

        p3 = new Label("Spieler 3");
        grid.setConstraints(p3, 4, 1);

        p4 = new Label("Spieler 4");
        grid.setConstraints(p4, 6, 1);



        // ------------------- Gridpane definieren für Gameboard-------------------
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
        grid.getChildren().addAll(player1, player2, player3, player4, p1, p2, p3, p4, pointsP1, pointsP2, pointsP3, pointsP4);

        // ------------------- BorderPane erstellen und HBox, VBox, Grid hinzufügen -------------------
        BorderPane welcome_pane = new BorderPane();
        welcome_pane.setBottom(grid);
        welcome_pane.setCenter(gameBoard);
        welcome_pane.setTop(labelPane);

        // ------------------- Stylesheets aufrufen -------------------
        welcome_pane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");
        welcome_pane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/font.css");

        // ------------------- BorderPane zu Scene hinzufügen und Fenstergrösse setzen -------------------
        scene = new Scene(welcome_pane, 1024, 640);

        String test[] = {"A","B","C"};
        LabelsArray = new Array[]{};
        Label label = new Label();

        for(int i=0; i<3; i++) {
            int x = i;
            int y = 0;
            label = new Label(test[i]);
            //gameBoard.add(LabelsArray.get(0), x, y);
        }


            //LabelsArray.add(test);
            //System.out.println(test[i]);



        //int ArrayPosition = 0;
        //for(int z=0; z<10; z++){
        //    int x = z;
        //        int y = 0;
        //        gameBoard.add(LabelsArray.get(ArrayPosition), x, y);
        //        ArrayPosition++;
        //    }
        //    gameBoard.add(LabelsArray.get(10), 9, 1);
        //    ArrayPosition = 11;
        //    for(int z=9; z>=0; z--){
        //        int x = z;
        //        int y = 2;
        //        gameBoard.add(LabelsArray.get(ArrayPosition), x, y);
        //        ArrayPosition++;
        //    }
        //    gameBoard.add(LabelsArray.get(21), 0, 3);
        //    ArrayPosition = 22;
        //    for(int z=0; z<10; z++){
        //        int x = z;
        //        int y = 4;
        //        gameBoard.add(LabelsArray.get(ArrayPosition), x, y);
        //        ArrayPosition++;
        //    }
        //    gameBoard.add(LabelsArray.get(32), 9, 5);
        //    ArrayPosition = 33;
        //    for(int z=9; z>=0; z--){
        //        int x = z;
        //        int y = 6;
        //        gameBoard.add(LabelsArray.get(ArrayPosition), x, y);
        //        ArrayPosition++;
        //    }
        //    gameBoard.add(LabelsArray.get(43), 0, 7);
        //    ArrayPosition = 44;
        //    for(int z=0; z<10; z++){
        //        int x = z;
        //        int y = 8;
        //        gameBoard.add(LabelsArray.get(ArrayPosition), x, y);
        //        ArrayPosition++;
        //    }
        //
        //    gameBoard.add(LabelsArray.get(54), 9, 9);



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
    //private void drawCards(ArrayList<Card> pathCards, ArrayList<Tile> tiles) {
        //
        //    for (Card card : pathCards) {
            //        for (Tile tile : tiles) {
                //            if (tile.getPathId() == 500) {
                    //                consoleTile = tile;
                    //            }
                //            if (card.getPathID() == tile.getPathId()) {
                    //                card.setWidth(tile.getSide());
                    //                card.setHeight(tile.getSide());
                    //                card.setLayoutX(tile.getX());
                    //                card.setLayoutY(tile.getY());
                    //                card.setStroke(Color.BLACK);
                    //
                    //                //addWater(card);
                    //
                    //                //addStartEndCard();
                    //
                    //                //card.addImagesToTile(model.htOfImages());
                    //                //TODO: At this place the card-image will be added to the card
                    //                //this.getChildren().add(card);
                    //            }
                //        }
            //    }
        //}

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

    public Label getPlayer1() {
        return player1;
    }
    public Label getPlayer2() {
        return player2;
    }
    public Label getPlayer3() {
        return player3;
    }
    public Label getPlayer4() {
        return player4;
    }

    public Label getPointsP1() {
        return pointsP1;
    }

    public Label getPointsP2() {
        return pointsP2;
    }

    public Label getPointsP3() {
        return pointsP3;
    }

    public Label getPointsP4() {
        return pointsP4;
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

