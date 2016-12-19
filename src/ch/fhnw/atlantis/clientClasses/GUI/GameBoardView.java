package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.globalClasses.models.*;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static ch.fhnw.atlantis.clientClasses.GUI.ImageLoader.getImage;


public class GameBoardView extends Pane {

    //-------------------- All Panes -----------------------------------
    private BorderPane gBPane;
    private GridPane gameBoard, playerGrid;
    private StackPane start, end, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16, pos17, pos18, pos19, pos20, pos21, pos22, pos23, pos24, pos25, cardPane, tilePane;
    private Scene scene;

    private Model model;

    public Button btnFinishTurn, btnBuyCard, btnNextCard, btnPlayCard, btnNextTile, btnPlayTile ;

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

    private Label pawnP1;
    private Label pawnP2;
    private Label pawnP3;
    private Label pawnP4;

    private int maxColIndex, maxRowIndex;

    public static int DisplayMovementCard = 0;
    public static int DisplayPathTile = 0;

    public static int PositionXPawnP1 = 1;
    public static int PositionYPawnP1 = 0;
    public static int PositionXPawnP2 = 2;
    public static int PositionYPawnP2 = 0;

    public GameBoardView() throws FileNotFoundException {

        maxColIndex = 16;
        maxRowIndex = 10;

        // ------------------- Grid für Player Icons -------------------
        playerGrid = new GridPane();

        playerGrid.setPadding(new Insets(20, 50, 20, 70));
        playerGrid.setVgap(10);
        playerGrid.setHgap(60);
        playerGrid.setGridLinesVisible(false);

        // ------------------- Player Icons -------------------
        player1 = new Label("\ue7FD");
        playerGrid.setConstraints(player1, 0    , 0);
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
        gameBoard.setHgap(0);
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

        //
        pawnP1 = new Label("\ue91D");
        pawnP2 = new Label("\ue532");
        pawnP3 = new Label("\ue16B");
        pawnP4 = new Label("\ue80C");
        pawnP3.setDisable(true);
        pawnP4.setDisable(true);


        // ------------------- Elemente definieren für Gameboard-------------------
        start = new StackPane();
        end = new StackPane();
        cardPane = new StackPane();
        tilePane = new StackPane();
        end.setId("end");
        start.setId("start");

        pos1 = new StackPane();
        pos2 = new StackPane();
        pos3 = new StackPane();
        pos4 = new StackPane();
        pos5 = new StackPane();
        pos6 = new StackPane();
        pos7 = new StackPane();
        pos8 = new StackPane();
        pos9 = new StackPane();
        pos10 = new StackPane();
        pos11 = new StackPane();
        pos12 = new StackPane();
        pos13 = new StackPane();
        pos14 = new StackPane();
        pos15 = new StackPane();
        pos16 = new StackPane();
        pos17 = new StackPane();
        pos18 = new StackPane();
        pos19 = new StackPane();
        pos20 = new StackPane();
        pos21 = new StackPane();
        pos22 = new StackPane();
        pos23 = new StackPane();
        pos24 = new StackPane();
        pos25 = new StackPane();

        btnBuyCard = new Button("Starte Spiel");
        btnFinishTurn = new Button("Zug beenden");
        btnFinishTurn.setDisable(true);
        btnNextCard = new Button("Nächste Karte");
        btnNextCard.setDisable(true);
        btnNextTile = new Button("Nächstes Plättchen");
        btnNextTile.setWrapText(true);
        btnNextTile.setDisable(true);
        btnPlayCard = new Button("Karte spielen");
        btnPlayCard.setDisable(true);
        btnPlayTile = new Button("Plättchen eintauschen");
        btnPlayTile.setWrapText(true);
        btnPlayTile.setDisable(true);


        gameBoard.setConstraints(pawnP3, 2, 0);
        gameBoard.setConstraints(pawnP4, 2, 2);
        gameBoard.setConstraints(start, 0, 0, 3, 3);

        gameBoard.setConstraints(cardPane, 5, 7, 2, 3);
        gameBoard.setConstraints(btnBuyCard, 5, 6, 2, 1);
        gameBoard.setConstraints(btnPlayCard, 3, 8, 2, 1);
        gameBoard.setConstraints(btnNextCard, 3, 9, 2, 1);

        gameBoard.setConstraints(tilePane, 8, 7, 2, 3);
        gameBoard.setConstraints(btnFinishTurn, 8, 6, 2, 1);
        gameBoard.setConstraints(btnPlayTile, 10, 8, 2, 1);
        gameBoard.setConstraints(btnNextTile, 10, 9, 2, 1);

        gameBoard.setConstraints(end, 13, 7, 3, 3);

        gameBoard.setConstraints(pos1, 1,3);
        gameBoard.setConstraints(pos2, 1,4);
        gameBoard.setConstraints(pos3, 1,5);
        gameBoard.setConstraints(pos4, 2,6);
        gameBoard.setConstraints(pos5, 3,6);
        gameBoard.setConstraints(pos6, 4,5);
        gameBoard.setConstraints(pos7, 4,4);
        gameBoard.setConstraints(pos8, 4,3);
        gameBoard.setConstraints(pos9, 4,2);
        gameBoard.setConstraints(pos10, 5,1);
        gameBoard.setConstraints(pos11, 6,2);
        gameBoard.setConstraints(pos12, 6,3);
        gameBoard.setConstraints(pos13, 7,4);
        gameBoard.setConstraints(pos14, 8,3);
        gameBoard.setConstraints(pos15, 8,2);
        gameBoard.setConstraints(pos16, 9,1);
        gameBoard.setConstraints(pos17, 10,1);
        gameBoard.setConstraints(pos18, 11,1);
        gameBoard.setConstraints(pos19, 12,1);
        gameBoard.setConstraints(pos20, 13,1);
        gameBoard.setConstraints(pos21, 14,2);
        gameBoard.setConstraints(pos22, 14,3);
        gameBoard.setConstraints(pos23, 14,4);
        gameBoard.setConstraints(pos24, 14,5);
        gameBoard.setConstraints(pos25, 14,6);

        gameBoard.setGridLinesVisible(false);


        // alle Inhalte in die Gridpanes holen mit getChildren
        gameBoard.getChildren().addAll(start, btnBuyCard, btnFinishTurn, btnNextCard, btnNextTile, btnPlayCard, btnPlayTile, cardPane, tilePane, end, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16, pos17, pos18, pos19, pos20, pos21, pos22, pos23, pos24, pos25, pawnP1, pawnP2, pawnP3, pawnP4);
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

    public Button getBtnBuyCard() {
        return btnBuyCard;
    }

    public void UpdatePositivePathTile(){
        DisplayPathTile ++;
    }

    public void UpdatePositiveMovementCard(){
        DisplayMovementCard ++;
    }

    /** Getter und Setter **/

    public Button getBtnFinishTurn() {
        return btnFinishTurn;
    }

    public void UpdateGUIThread() {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                            try {
                                UpdateValues();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                );
            }// Change delay to 300 after testing
        }, 0, 300, TimeUnit.MILLISECONDS);
    }

    public void UpdateValues() throws FileNotFoundException {
        ImageLoader imageLoader = new ImageLoader();
        PlayerClient playerClient = new PlayerClient();

            // Hand Wegplättchen Anzeigen
            tilePane.setBackground(new Background(new BackgroundImage(imageLoader.getPlayerPathTileHand(DisplayPathTile),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            // Hand Bewegungskarten Anzeigen
            cardPane.setBackground(new Background(new BackgroundImage(imageLoader.getPlayerMovementCardHand(DisplayMovementCard),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

            // Pawn
            gameBoard.setConstraints(pawnP1, PositionXPawnP1, PositionYPawnP1);
            gameBoard.setConstraints(pawnP2, PositionXPawnP2, PositionYPawnP2);

            // Buttons Enable/Disable if it's player's turn
            btnPlayTile.setDisable(playerClient.isItMyTurn());
            btnPlayCard.setDisable(playerClient.isItMyTurn());
            btnNextTile.setDisable(playerClient.isItMyTurn());
            btnNextCard.setDisable(playerClient.isItMyTurn());
            btnFinishTurn.setDisable(playerClient.isItMyTurn());

            // Wegplättchen
            pos1.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(1),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos2.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(2),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos3.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(3),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos4.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(4),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos5.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(5),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos6.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(6),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos7.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(7),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos8.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(8),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos9.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(9),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos10.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(10),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos11.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(11),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos12.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(12),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos13.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(13),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos14.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(14),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos15.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(15),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos16.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(16),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos17.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(17),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos18.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(18),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos19.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(19),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos20.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(20),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos21.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(21),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos22.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(22),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos23.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(23),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos24.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(24),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos25.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(25),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    public String getDisplayPathTile(){
        PlayerClient playerClient = new PlayerClient();
        return playerClient.getPlayerPathTileHandGUI(DisplayPathTile);
        //return DisplayPathTile;
    }

    public void sendPathTileExchange(){
        PlayerClient playerClient = new PlayerClient();
        playerClient.addPlayerToString("ExchangePathTileValue_"+getDisplayPathTile());
        System.out.println(getDisplayPathTile());

    }

    public void setPositionPawnP1(int x, int y){
        PositionXPawnP1 = x;
        PositionYPawnP1 = y;
    }

    public void setPositionPawnP2(int x, int y){
        PositionXPawnP2 = x;
        PositionYPawnP2 = y;
    }

    public Button getBtnPlayCard() {
        return btnPlayCard;
    }

    public Button getBtnNextTile() { return btnNextTile; }

    public Button getBtnNextCard() { return btnNextCard; }

    public Button getBtnPlayTile() {
        return btnPlayTile;
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

    public Label getPawnP1() {
        return pawnP1;
    }

    public Label getPawnP2() {
        return pawnP2;
    }

    public Label getPawnP3() {
        return pawnP3;
    }

    public Label getPawnP4() {
        return pawnP4;
    }
}