package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

    private MenuButton btnStartGame;
    private MenuButton btnOptions;
    private MenuButton btnExit;
    private MenuButton btnBack;

    private MenuButton btnSprache1;
    private MenuButton btnSprache2;

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
        btnStartGame = new MenuButton("SPIEL STARTEN");
        btnOptions = new MenuButton("OPTIONEN");
        btnExit = new MenuButton("SCHLIESSEN");
        btnBack = new MenuButton("ZURÜCK");

        // ------------------- Buttons Untermenu -------------------
        btnSprache1 = new MenuButton("DEUTSCH");
        btnSprache2 = new MenuButton("ENGLISCH");

        // ------------------- Buttons vertikal anordnen -------------------
        menu0 = new VBox(btnStartGame, btnOptions, btnExit, btnBack);
        menu0.setAlignment(Pos.BASELINE_LEFT);
        menu0.setPadding(new Insets(50));
        menu0.setSpacing(10);

        menu1 = new VBox(btnSprache1, btnSprache2);
        menu1.setAlignment(Pos.BASELINE_LEFT);
        menu1.setPadding(new Insets(50));
        menu1.setSpacing(10);

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



        // ------------------- Stylesheets aufrufen -------------------
        scene.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");

        // ------------------- BorderPane zu Scene hinzufügen und Fenstergrösse setzen -------------------
        scene = new Scene(gmpane, 800, 600);
        }

        // ------------------- View der Stage bekannt geben -------------------
        public void show(Stage stage) {
        stage.setTitle("Atlantis by Team Gerstenland");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        // ------------------- Bild in Stage Titel laden  -------------------
        Image icon = new Image(getClass().getResourceAsStream("./../../resources/images/atlantis_client.jpg"));
        stage.getIcons().add(icon);

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

    public Stage getGameMenu_stage() {
        return gameMenu_stage;
    }

    public void setGameMenu_stage(Stage gameMenu_stage) {
        this.gameMenu_stage = gameMenu_stage;
    }

    public MenuButton getBtnStartGame() {
        return btnStartGame;
    }

    public void setBtnStartGame(MenuButton btnStartGame) {
        this.btnStartGame = btnStartGame;
    }

    public MenuButton getBtnOptions() {
        return btnOptions;
    }

    public void setBtnOptions(MenuButton btnOptions) {
        this.btnOptions = btnOptions;
    }

    public MenuButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(MenuButton btnExit) {
        this.btnExit = btnExit;
    }

    public MenuButton getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(MenuButton btnBack) {
        this.btnBack = btnBack;
    }

    public MenuButton getBtnSprache1() {
        return btnSprache1;
    }

    public void setBtnSprache1(MenuButton btnSprache1) {
        this.btnSprache1 = btnSprache1;
    }

    public MenuButton getBtnSprache2() {
        return btnSprache2;
    }

    public void setBtnSprache2(MenuButton btnSprache2) {
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

       }