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

    public Button btnFinishTurn, btnBuyCard, btnNextCard, btnPlayCard, btnNextTile, btnPlayTile;

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

    private Label showRules;

    private int maxColIndex, maxRowIndex;

    public static int DisplayMovementCard = 0;
    public static int DisplayPathTile = 0;

    public static int PositionXPawnP1 = 1;
    public static int PositionYPawnP1 = 1;
    public static int PositionXPawnP2 = 2;
    public static int PositionYPawnP2 = 1;

    public static String Pawn1 = "\ue91D";
    public static String Pawn2 = "\ue532";
    public static String Pawn3 = "\ue16B";
    public static String Pawn4 = "\ue80C";

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
        player1 = new Label(Pawn1);
        playerGrid.setConstraints(player1, 1    , 0);
        playerGrid.setHalignment(player1, HPos.CENTER);
        pointsP1 = new Label("Im Ziel:\n0/3");
        playerGrid.setHalignment(pointsP1, HPos.CENTER);
        playerGrid.setConstraints(pointsP1, 2, 0 );

        player2 = new Label(Pawn2);
        playerGrid.setConstraints(player2, 6, 0);
        playerGrid.setHalignment(player2, HPos.CENTER);
        pointsP2 = new Label("Im Ziel:\n0/3");
        playerGrid.setHalignment(pointsP2, HPos.CENTER);
        playerGrid.setConstraints(pointsP2, 7, 0 );

        player3 = new Label("\ue7FD");
        playerGrid.setConstraints(player3, 4, 0);
        playerGrid.setHalignment(player3, HPos.CENTER);
        player3.setDisable(true);
        pointsP3 = new Label("0");
        playerGrid.setConstraints(pointsP3, 5, 0 );
        playerGrid.setHalignment(pointsP3, HPos.CENTER);

        player4 = new Label("\ue7FD");
        playerGrid.setConstraints(player4, 6, 0);
        playerGrid.setHalignment(player4, HPos.CENTER);
        player4.setDisable(true);
        pointsP4 = new Label("0");
        playerGrid.setConstraints(pointsP4, 7, 0 );
        playerGrid.setHalignment(pointsP4, HPos.CENTER);

        // ------------------- Player Labels definieren ---------
        p1 = new Label("Spieler 1");
        playerGrid.setConstraints(p1, 1, 1);
        p2 = new Label("Spieler 2");
        playerGrid.setConstraints(p2, 6, 1);
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

        pawnP1 = new Label(Pawn1);
        pawnP2 = new Label(Pawn2);
        pawnP3 = new Label(Pawn3);
        pawnP4 = new Label(Pawn4);
        pawnP3.setVisible(false);
        pawnP4.setVisible(false);


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

        btnBuyCard = new Button("Lade Spielbrett");
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
        playerGrid.getChildren().addAll(player1, player2, p1, p2, pointsP1, pointsP2);


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
        }, 0, 350, TimeUnit.MILLISECONDS);
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

            // Pawn im Ziel
            getPlayerOneOnLand();
            getPlayerTwoOnLand();
            setPawnP1("X");
            setPawnP2("X");

            // Buttons Enable/Disable if it's player's turn
            btnPlayTile.setDisable(playerClient.isItMyTurnPathTile());
            btnPlayCard.setDisable(playerClient.isItMyTurnMovementCard());
            btnNextTile.setDisable(playerClient.isItMyTurn());
            btnNextCard.setDisable(playerClient.isItMyTurn());
            btnFinishTurn.setDisable(playerClient.isItMyTurn());

            // Wegplättchen
            pos1.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(0),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos2.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(1),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos3.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(2),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos4.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(3),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos5.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(4),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos6.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(5),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos7.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(6),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos8.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(7),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos9.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(8),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos10.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(9),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos11.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(10),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos12.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(11),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos13.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(12),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos14.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(13),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos15.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(14),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos16.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(15),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos17.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(16),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos18.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(17),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos19.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(18),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos20.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(19),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos21.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(20),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos22.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(21),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos23.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(22),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos24.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(23),
                    BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            pos25.setBackground(new Background(new BackgroundImage(imageLoader.getPathTile(24),
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

    public void getPlayerOneOnLand(){
        PlayerClient playerClient = new PlayerClient();
        pointsP1.setText("Im Ziel:\n"+playerClient.getPlayerOneOnLand()+"/3");
    }

    public void getPlayerTwoOnLand(){
        PlayerClient playerClient = new PlayerClient();
        pointsP2.setText("Im Ziel:\n"+playerClient.getPlayerTwoOnLand()+"/3");
    }

    public void setPositionPawnP2(int x, int y){
        PositionXPawnP2 = x;
        PositionYPawnP2 = y;
    }

    public void playMovementCard() {
        PlayerClient playerClient = new PlayerClient();
        playerClient.getMovementCardNameFromArrayNumber(DisplayMovementCard);
    }

    public void setPawnP1(String pawn){
        switch (pawn) {
            case "1":
                Pawn1 = "\ue91D";
                break;
            case "2":
                Pawn1 = "\ue532";
                break;
            case "3":
                Pawn1 = "\ue16B";
                break;
            case "4":
                Pawn1 = "\ue80C";
                System.out.println("echo: "+pawnP1);
                break;
            default:
                break;
        }
    }

    public void setPawnP2(String pawn){
        switch (pawn) {
            case "1":
                Pawn2 = "\ue91D";
                break;
            case "2":
                Pawn2 = "\ue532";
                break;
            case "3":
                Pawn2 = "\ue16B";
                break;
            case "4":
                Pawn2 = "\ue80C";
                break;
            default:
                break;
        }
    }

    public Button getBtnPlayCard() {
        return btnPlayCard;
    }

    public Button getBtnNextTile() { return btnNextTile; }

    public Button getBtnNextCard() { return btnNextCard; }

    public Button getBtnPlayTile() {
        return btnPlayTile;
    }

    public Label getShowRules() {return showRules; }

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