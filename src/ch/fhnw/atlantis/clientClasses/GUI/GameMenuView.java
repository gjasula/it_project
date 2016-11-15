package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Nadine on 25.10.2016.
 */

public class GameMenuView {
    private Scene scene;

    private BorderPane gmpane;
    private GridPane grid;
    private Stage gameMenu_stage;

    private Button btnStartGame;
    private Button btnOptions;
    private Button btnExit;
    private Button btnBack;

    private Button btnSprache1;
    private Button btnSprache2;

    private VBox menu0;
    private VBox menu1;

    private Label p1;
    private Label p2;
    private Label p3;
    private Label p4;

    private Label player1;
    private Label player2;
    private Label player3;
    private Label player4;

    public GameMenuView() {

        // ------------------- Buttons Hauptmenu -------------------
        btnStartGame = new Button("SPIEL STARTEN");
        btnOptions = new Button("OPTIONEN");
        btnExit = new Button("SCHLIESSEN");
        btnBack = new Button("ZURÜCK");

        // ------------------- Buttons Untermenu -------------------
        btnSprache1 = new Button("DEUTSCH");
        btnSprache2 = new Button("ENGLISCH");

        // ------------------- Buttons vertikal anordnen -------------------
        menu0 = new VBox(btnStartGame, btnOptions, btnExit, btnBack);
        menu0.setAlignment(Pos.BASELINE_LEFT);
        menu0.setPadding(new Insets(50));
        menu0.setSpacing(10);
        menu0.setId("Button");


        menu1 = new VBox(btnSprache1, btnSprache2);
        menu1.setAlignment(Pos.BASELINE_LEFT);
        menu1.setPadding(new Insets(50));
        menu1.setSpacing(10);

        //------------------- Player Icons -------------------
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

        // ------------------- CSS den Icons zuweisen ---------
        player1.setId("Playerafter");
        player2.setId("Playerafter");
        player3.setId("Playerbefore");
        player4.setId("Playerbefore");

        // ------------------- Player Labels definieren ---------
        p1 = new Label("Spieler 1");
        grid.setConstraints(p1, 0, 1);
        p2 = new Label("Spieler 2");
        grid.setConstraints(p2, 1, 1);
        p3 = new Label("Spieler 3");
        grid.setConstraints(p3, 2, 1);
        p4 = new Label("Spieler 4");
        grid.setConstraints(p4, 3, 1);

        // ------------------- Gridpane definieren für Players-------------------
        grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 120));
        grid.setVgap(0);
        grid.setHgap(150);
        grid.setGridLinesVisible(false);

        // alle Inhalte ins Grid holen mit getChildren
        grid.getChildren().addAll(player1, player2, player3, player4, p1, p2, p3, p4);


        // ------------------- BorderPane erstellen und HBox, VBox, Grid hinzufügen -------------------
        BorderPane gmpane = new BorderPane();
        gmpane.setBottom(grid);
        gmpane.setLeft(menu0);


        // ------------------- Stylesheets aufrufen -------------------
        gmpane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");

        // ------------------- BorderPane zu Scene hinzufügen und Fenstergrösse setzen -------------------
        scene = new Scene(gmpane, 1024, 640);

    }
    // ------------------- View der Stage bekannt geben -------------------
        public void show(Stage stage) {
        stage.setTitle("Atlantis by Team Gerstenland");
        stage.setResizable(false);
        // ------------------- Bild in Stage Titel laden  -------------------
        Image icon = new Image(getClass().getResourceAsStream("./../../resources/images/atlantis_client.jpg"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
    // ------------------- Getter Funktionen auf Element, für Interaktion -------------------
    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public BorderPane getGmpane() {
        return gmpane;
    }

    public void setGmpane(BorderPane gmpane) {
        this.gmpane = gmpane;
    }

    public GridPane getGrid() {
        return grid;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    public Stage getGameMenu_stage() {
        return gameMenu_stage;
    }

    public void setGameMenu_stage(Stage gameMenu_stage) {
        this.gameMenu_stage = gameMenu_stage;
    }

    public Button getBtnStartGame() {
        return btnStartGame;
    }

    public void setBtnStartGame(Button btnStartGame) {
        this.btnStartGame = btnStartGame;
    }

    public Button getBtnOptions() {
        return btnOptions;
    }

    public void setBtnOptions(Button btnOptions) {
        this.btnOptions = btnOptions;
    }

    public Button getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(Button btnExit) {
        this.btnExit = btnExit;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    public Button getBtnSprache1() {
        return btnSprache1;
    }

    public void setBtnSprache1(Button btnSprache1) {
        this.btnSprache1 = btnSprache1;
    }

    public Button getBtnSprache2() {
        return btnSprache2;
    }

    public void setBtnSprache2(Button btnSprache2) {
        this.btnSprache2 = btnSprache2;
    }

    public VBox getMenu0() {
        return menu0;
    }

    public void setMenu0(VBox menu0) {
        this.menu0 = menu0;
    }

    public VBox getMenu1() {
        return menu1;
    }

    public void setMenu1(VBox menu1) {
        this.menu1 = menu1;
    }

    public Label getP1() {
        return p1;
    }

    public void setP1(Label p1) {
        this.p1 = p1;
    }

    public Label getP2() {
        return p2;
    }

    public void setP2(Label p2) {
        this.p2 = p2;
    }

    public Label getP3() {
        return p3;
    }

    public void setP3(Label p3) {
        this.p3 = p3;
    }

    public Label getP4() {
        return p4;
    }

    public void setP4(Label p4) {
        this.p4 = p4;
    }

    public Label getPlayer1() {
        return player1;
    }

    public void setPlayer1(Label player1) {
        this.player1 = player1;
    }

    public Label getPlayer2() {
        return player2;
    }

    public void setPlayer2(Label player2) {
        this.player2 = player2;
    }

    public Label getPlayer3() {
        return player3;
    }

    public void setPlayer3(Label player3) {
        this.player3 = player3;
    }

    public Label getPlayer4() {
        return player4;
    }

    public void setPlayer4(Label player4) {
        this.player4 = player4;
    }

    }



