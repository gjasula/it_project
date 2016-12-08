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

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static ch.fhnw.atlantis.globalClasses.ImageLoader.getImage;


public class GameBoardView extends Pane {

    private final ArrayList<Label> LabelsArray;
    private ArrayList<Player> players;
    private ArrayList<Card> pathCards;

    //-------------------- All Panes -----------------------------------
    private BorderPane gBPane;
    private GridPane gameBoard, playerGrid;
    private StackPane start, end;
    private Scene scene;

    private HashMap<Integer, Label> scoresLabels;
    private Model model;


    private Image atlantis, mainland;

    private HBox cardPane;

    private Button btnFinishTurn;
    private Button btnBuyCard;

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

    private int maxColIndex, maxRowIndex;

    public GameBoardView() throws FileNotFoundException {

        maxColIndex = 16;
        maxRowIndex = 10;

        LabelsArray = new ArrayList<>();
        atlantis = new Image(getClass().getResourceAsStream("./../../resources/images/start.jpg"));

        // ------------------- Grid für Player Icons -------------------
        playerGrid = new GridPane();

        playerGrid.setPadding(new Insets(20, 50, 20, 70));
        playerGrid.setVgap(10);
        playerGrid.setHgap(60);
        playerGrid.setGridLinesVisible(false);

        // ------------------- Player Icons -------------------
        player1 = new Label("\ue7FD");
        playerGrid.setConstraints(player1, 0, 0);
        playerGrid.setHalignment(player1, HPos.CENTER);
        pointsP1 = new Label("0");
        playerGrid.setConstraints(pointsP1, 1, 0 );
        playerGrid.setHalignment(pointsP1, HPos.CENTER);

        player2 = new Label("\ue7FD");
        playerGrid.setConstraints(player2, 2, 0);
        playerGrid.setHalignment(player2, HPos.CENTER);
        pointsP2 = new Label("0");
        playerGrid.setConstraints(pointsP2, 3, 0 );
        playerGrid.setHalignment(pointsP2, HPos.CENTER);

        player3 = new Label("\ue7FD");
        playerGrid.setConstraints(player3, 4, 0);
        playerGrid.setHalignment(player3, HPos.CENTER);
        pointsP3 = new Label("0");
        playerGrid.setConstraints(pointsP3, 5, 0 );
        playerGrid.setHalignment(pointsP3, HPos.CENTER);

        player4 = new Label("\ue7FD");
        playerGrid.setConstraints(player4, 6, 0);
        playerGrid.setHalignment(player4, HPos.CENTER);
        pointsP4 = new Label("0");
        playerGrid.setConstraints(pointsP4, 7, 0 );
        playerGrid.setHalignment(pointsP4, HPos.CENTER);

        // ------------------- Player Labels definieren ---------
        p1 = new Label("Spieler 1");
        playerGrid.setConstraints(p1, 0, 1);
        p2 = new Label("Spieler 2");
        playerGrid.setConstraints(p2, 2, 1);
        p3 = new Label("Spieler 3");
        playerGrid.setConstraints(p3, 4, 1);
        p4 = new Label("Spieler 4");
        playerGrid.setConstraints(p4, 6, 1);

        // ------------------- Gridpane definieren für Gameboard-------------------
        gameBoard = new GridPane();
        gameBoard.setHgap(5);
        gameBoard.setVgap(5);

        gameBoard.setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < maxColIndex; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPrefWidth(70);
            gameBoard.getColumnConstraints().add(cc);
        }
        for (int i = 0; i < maxRowIndex; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setPrefHeight(70);
            gameBoard.getRowConstraints().add(rc);
        }

        // Filling the labels of each Tile with the Serverside-created ArrayList
        for(int i=0; i<55; i++){
            // Label label = new Label(GameBoard.aLArray[i].get(0).toString());
            //LabelsArray.add(label);
        }

        // ------------------- Elemente definieren für Gameboard-------------------
        start = new StackPane();
        end = new StackPane();
        start.setBackground(new Background(new BackgroundImage(getImage("start.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        end.setBackground(new Background(new BackgroundImage(getImage("ende.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        btnBuyCard = new Button("Karte kaufen");
        btnFinishTurn = new Button("Zug beenden");

        cardPane = new HBox();
        cardPane.setStyle(" -fx-background-color: #ffffff; -fx-opacity: 0.6;");
        cardPane.setOpacity(20);

        gameBoard.setConstraints(start, 0,0,3,3);
        gameBoard.setConstraints(btnBuyCard, 6,6, 2, 1);
        gameBoard.setConstraints(btnFinishTurn, 9,6,2,1);
        gameBoard.setConstraints(cardPane, 5, 7,7,3);
        gameBoard.setConstraints(end, 13, 7,3,3);

        gameBoard.setGridLinesVisible(true);


        // alle Inhalte in die Gridpanes holen mit getChildren
        gameBoard.getChildren().addAll(btnBuyCard,btnFinishTurn, cardPane, start, end);
        playerGrid.getChildren().addAll(player1, player2, player3, player4, p1, p2, p3, p4, pointsP1, pointsP2, pointsP3, pointsP4);

        // ------------------- BorderPane erstellen und HBox, VBox, Gameboard und playerGrid hinzufügen -------------------
        BorderPane gBPane = new BorderPane();
        gBPane.setBottom(playerGrid);
        gBPane.setCenter(gameBoard);

        // ------------------- Stylesheets aufrufen -------------------
        gBPane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");
        gBPane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/font.css");

        // ------------------- BorderPane zu Scene hinzufügen und Fenstergrösse setzen -------------------
        scene = new Scene(gBPane, 1024, 640);

        //drawPawns();
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
     */
    int co = 2;
    int ro = 1;

    // add stacks to the mainBoard
    private void addToMainBoard(Tile water) {

        if (((ro == 1) || (ro == 5) || (ro == 9)) && co != maxColIndex) {

            gameBoard.add(water, co, ro);
            co++;
        } else if (co == maxColIndex && ((ro == 1) || (ro == 5) || (ro == 9))) {

            gameBoard.add(water, maxColIndex - 1, ro + 1);
            ro += 2;
            co -= 1;
        } else if (((ro == 3) || (ro == 7) || (ro == 11)) && co <= maxColIndex && co != 0) {

            gameBoard.add(water, co, ro);
            co--;

        } else if (co == 0 && ((ro == 3) || (ro == 7) || (ro == 11))) {
            gameBoard.add(water, 1, ro + 1);
            ro += 2;
            co += 1;
        }
    }

    // this method adds a Rectangle and Text to each landtile
    public void addRecAndText(ArrayList<Tile> base) throws FileNotFoundException {
        //this.base = base;
        for (int i = 0; i < base.size(); i++) {

            Tile water = base.get(i);
            water.setBackground(new Background(new BackgroundImage(getImage("water.jpg"), BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            //water.convertToChildren();

            //if (water.getChildren().size() != 0) {
            //    for (int k = 0; k < water.getChildren().size(); k++) {
//
            //        Tile tile = (Tile) water.getChildren().get(k);
            //        ImageView iV = new ImageView();
            //        iV.setFitWidth(60);
            //        iV.setFitWidth(60);
            //        tile.getChildren().addAll(iV,
            //                new Text(String.valueOf(tile.getTileValue()) + "\n" + tile.getColor().toString()));
//
            //    }
            //}

            addToMainBoard(water);
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
            //TileType Enum gibt noch einen Fehler da nicht public
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
                    this.getChildren().add(pawn);
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
