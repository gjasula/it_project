package ch.fhnw.atlantis.clientClasses.GUI;

import ch.fhnw.atlantis.serverClasses.Main;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Nadine on 25.10.2016.
 */

public class MenuView {
    private Scene scene;

    private BorderPane gmpane;
    private GridPane grid;
    private Stage gameMenu_stage;

    private Button btnStartGame;
    private Button btnOptions;
    private Button btnRules;
    private Button btnPlayer;
    private Button btnExit;
    private Button btnBack;

    private Button btnSprache1;
    private Button btnSprache2;
    private Button btnSprache3;

    private GridPane MainMenu;
    private GridPane SubMenu;

    private Label p1;
    private Label p2;
    private Label p3;
    private Label p4;

    private Label player1;
    private Label player2;
    private Label player3;
    private Label player4;

    private Label menuIconStart;
    private Label menuIconOpt;
    private Label menuIconPlayer;
    private Label menuIconRule;
    private Label menuIconExit;
    private Label menuIconBack;

    private Label txtAtlantis;
    private Label txt;

    private Image Flag_GB;
    private Image Flag_Germany;
    private Image Flag_Switzerland;
    private Image Flag1;

    private ImageView iview1;
    private ImageView iview2;
    private ImageView iview3;

    private Button gameCharacter1;
    private Button gameCharacter2;
    private Button gameCharacter3;
    private Button gameCharacter4;


    public MenuView() {

        // ------------------- Buttons MenuMain definieren und in Gridanordnen -------------------
        btnStartGame = new Button("SPIEL STARTEN");
        btnOptions = new Button("SPRACHE WÄHLEN");
        btnPlayer = new Button("SPIELFIGUR WÄHLEN");
        btnRules = new Button("SPIELREGELN");
        btnBack = new Button("ZURÜCK");
        btnExit = new Button("SCHLIESSEN");

        MainMenu.setConstraints(btnStartGame, 1, 0);
        MainMenu.setConstraints(btnOptions, 1, 1);
        MainMenu.setConstraints(btnPlayer, 1, 2);
        MainMenu.setConstraints(btnRules, 1, 3);
        MainMenu.setConstraints(btnBack, 1, 4);
        MainMenu.setConstraints(btnExit, 1, 5);

        // ------------------- ICONS MenuMain definieren, in Grid anordnen, CSS ID setzen  -------------------
        menuIconStart = new Label("\ue037");
        menuIconOpt = new Label("\ue894");
        menuIconPlayer = new Label("\ue87B");
        menuIconRule = new Label("\ue873");
        menuIconExit = new Label("\ue020");
        menuIconBack = new Label("\ue14C");

        MainMenu.setConstraints(menuIconStart, 0, 0);
        MainMenu.setConstraints(menuIconOpt, 0, 1);
        MainMenu.setConstraints(menuIconPlayer, 0, 2);
        MainMenu.setConstraints(menuIconRule, 0, 3);
        MainMenu.setConstraints(menuIconExit, 0, 4);
        MainMenu.setConstraints(menuIconBack, 0, 5);

        menuIconStart.setId("MenuIcon");
        menuIconOpt.setId("MenuIcon");
        menuIconPlayer.setId("MenuIcon");
        menuIconRule.setId("MenuIcon");
        menuIconExit.setId("MenuIcon");
        menuIconBack.setId("MenuIcon");

        // ------------------- Buttons und MenuIcons in Grid anordnen -------------------
        MainMenu = new GridPane();
        MainMenu.setPadding(new Insets(20, 20, 20, 20));
        MainMenu.setVgap(5);
        MainMenu.setHgap(7);
        MainMenu.setGridLinesVisible(false);
        // alle Inhalte ins Grid holen mit getChildren
        MainMenu.getChildren().addAll(btnStartGame, btnOptions, btnPlayer, btnRules,
                btnBack, btnExit, menuIconStart, menuIconOpt, menuIconPlayer, menuIconRule, menuIconExit, menuIconBack);

        // ------------------- Buttons SubMenu definieren, in Grid anordnen und Verbergen -------------------
        btnSprache1 = new Button("DEUTSCH");
        btnSprache2 = new Button("ENGLISCH");
        btnSprache3 = new Button("SCHWIIZERDÜTSCH");

        btnSprache1.setVisible(false);
        btnSprache2.setVisible(false);
        btnSprache3.setVisible(false);

        SubMenu.setConstraints(btnSprache1, 2,2);
        SubMenu.setConstraints(btnSprache2, 3,2);
        SubMenu.setConstraints(btnSprache3, 4,2);

        txtAtlantis = new Label(TEXT);
        txtAtlantis.setWrapText(true);
        txtAtlantis.setId("Label-text");
        txtAtlantis.setVisible(true);

        SubMenu.setConstraints(txtAtlantis, 1, 1);
        SubMenu.setColumnSpan(txtAtlantis, 5);
        SubMenu.setRowSpan(txtAtlantis,4);

        txt = new Label();
        txt.setWrapText(true);
        txt.setVisible(true);

        SubMenu.setConstraints(txt, 0,0);
        SubMenu.setColumnSpan(txt, 5);

        // ------------------- Flaggen SubMenu -------------------
        Flag_GB = new Image("/ch/fhnw/atlantis/resources/images/Flag_GB.png");
        iview1 = new ImageView(Flag_GB);
        iview1.setVisible(false);
        SubMenu.setConstraints(iview1, 3, 1);
        SubMenu.setHalignment(iview1, HPos.CENTER);

        Flag_Germany = new Image("/ch/fhnw/atlantis/resources/images/Flag_Germany.png");
        iview2 = new ImageView(Flag_Germany);
        iview2.setVisible(false);
        SubMenu.setConstraints(iview2, 2, 1);
        SubMenu.setHalignment(iview2, HPos.CENTER);

        Flag_Switzerland = new Image("/ch/fhnw/atlantis/resources/images/Flag_Switzerland.png");
        iview3 = new ImageView(Flag_Switzerland);
        iview3.setVisible(false);
        SubMenu.setConstraints(iview3, 4, 1);
        SubMenu.setHalignment(iview3, HPos.CENTER);

        // ------------------- menuPlayer -------------------
        gameCharacter1 = new Button("\ue91D");
        gameCharacter2 = new Button("\ue532");
        gameCharacter3 = new Button("\ue16B");
        gameCharacter4 = new Button("\ue80C");

        SubMenu.setConstraints(gameCharacter1, 2,1);
        SubMenu.setConstraints(gameCharacter2, 3,1);
        SubMenu.setConstraints(gameCharacter3, 4,1);
        SubMenu.setConstraints(gameCharacter4, 5,1);

        gameCharacter1.setId("PlayerIcon");
        gameCharacter2.setId("PlayerIcon");
        gameCharacter3.setId("PlayerIcon");
        gameCharacter4.setId("PlayerIcon");

        gameCharacter1.setVisible(false);
        gameCharacter2.setVisible(false);
        gameCharacter3.setVisible(false);
        gameCharacter4.setVisible(false);

       // ------------------- SubMenu: Inhalte in Grid anordnen -------------------
        SubMenu = new GridPane();
        SubMenu.setPadding(new Insets(60, 60, 100, 100));   // top, right, bottom, left
        SubMenu.setVgap(5);
        SubMenu.setHgap(5);
        SubMenu.setGridLinesVisible(false);
        // alle Inhalte ins Grid holen mit getChildren
        SubMenu.getChildren().addAll(btnSprache1, btnSprache2, btnSprache3, iview1,
                iview2, iview3, gameCharacter1, gameCharacter2, gameCharacter3, gameCharacter4, txt, txtAtlantis);

        //------------------- Player_Old Icons und Grid anordnen -------------------
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

        // ------------------- CSS den Icons zuweisen --> über Controller implementiert---------
        //  player1.setId("Playerbefore");
        //  player2.setId("Playerbefore");
        //  player3.setId("Playerbefore");
        //  player4.setId("Playerbefore");

        // ------------------- Player_Old Labels definieren ---------
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
        gmpane.setLeft(MainMenu);
        gmpane.setCenter(SubMenu);

        // ------------------- Stylesheets aufrufen -------------------
        gmpane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");
        gmpane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/font.css");

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

    private static final String TEXT =
            "Bleibt wachsam - selbst die mächtigsten Staaten können jederzeit untergehen \n"+
            "\n"+
            "Ein erfundener Mythos oder Realität? \n" +
            "Bis Heute ist das Rätsel, um die versunkene Stadt Atlantis ungelöst. Die angeblich prächtigste und mächtigste Stadt der Welt, versunken in den Fluten des Meeres.\n" +
            "Das verschwundene Paradies verschluckt vom Wasser innerhalb eines Tages und einer Nacht. \n" +
            "\n"+
            "Rettet euer Hab und Gut, schnell von der Insel!";

    // ------------------- Getter und Setter -------------------

    public Label getTxt() {
        return txt;
    }

    public void setTxt(Label txt) {
        this.txt = txt;
    }

    public Label getTxtAtlantis() {
        return txtAtlantis;
    }

    public void setTxtAtlantis(Label txtAtlantis) {
        this.txtAtlantis = txtAtlantis;
    }

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

    public Button getBtnRules() {
        return btnRules;
    }

    public void setBtnRules(Button btnRules) {
        this.btnRules = btnRules;
    }

    public Button getBtnPlayer() {
        return btnPlayer;
    }

    public void setBtnPlayer(Button btnPlayer) {
        this.btnPlayer = btnPlayer;
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

    public Button getBtnSprache3() {
        return btnSprache3;
    }

    public void setBtnSprache3(Button btnSprache3) {
        this.btnSprache3 = btnSprache3;
    }

    public GridPane getMainMenu() {
        return MainMenu;
    }

    public void setMainMenu(GridPane mainMenu) {
        this.MainMenu = mainMenu;
    }

    public GridPane getSubMenu() {
        return SubMenu;
    }

    public void setSubMenu(GridPane subMenu) {
        this.SubMenu = subMenu;
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

    public Label getMenuIconStart() {
        return menuIconStart;
    }

    public void setMenuIconStart(Label menuIconStart) {
        this.menuIconStart = menuIconStart;
    }

    public Label getMenuIconOpt() {
        return menuIconOpt;
    }

    public void setMenuIconOpt(Label menuIconOpt) {
        this.menuIconOpt = menuIconOpt;
    }

    public Label getMenuIconPlayer() {
        return menuIconPlayer;
    }

    public void setMenuIconPlayer(Label menuIconPlayer) {
        this.menuIconPlayer = menuIconPlayer;
    }

    public Label getMenuIconRule() {
        return menuIconRule;
    }

    public void setMenuIconRule(Label menuIconRule) {
        this.menuIconRule = menuIconRule;
    }

    public Label getMenuIconExit() {
        return menuIconExit;
    }

    public void setMenuIconExit(Label menuIconExit) {
        this.menuIconExit = menuIconExit;
    }

    public Label getMenuIconBack() {
        return menuIconBack;
    }

    public void setMenuIconBack(Label menuIconBack) {
        this.menuIconBack = menuIconBack;
    }

    public Image getFlag_GB() {
        return Flag_GB;
    }

    public void setFlag_GB(Image flag_GB) {
        Flag_GB = flag_GB;
    }

    public Image getFlag_Germany() {
        return Flag_Germany;
    }

    public void setFlag_Germany(Image flag_Germany) {
        Flag_Germany = flag_Germany;
    }

    public Image getFlag_Switzerland() {
        return Flag_Switzerland;
    }

    public void setFlag_Switzerland(Image flag_Switzerland) {
        Flag_Switzerland = flag_Switzerland;
    }

    public Image getFlag1() {
        return Flag1;
    }

    public void setFlag1(Image flag1) {
        Flag1 = flag1;
    }

    public ImageView getIview1() {
        return iview1;
    }

    public void setIview1(ImageView iview1) {
        this.iview1 = iview1;
    }

    public ImageView getIview2() {
        return iview2;
    }

    public void setIview2(ImageView iview2) {
        this.iview2 = iview2;
    }

    public ImageView getIview3() {
        return iview3;
    }

    public void setIview3(ImageView iview3) {
        this.iview3 = iview3;
    }

    public Button getGameCharacter1() {
        return gameCharacter1;
    }

    public void setGameCharacter1(Button gameCharacter1) {
        this.gameCharacter1 = gameCharacter1;
    }

    public Button getGameCharacter2() {
        return gameCharacter2;
    }

    public void setGameCharacter2(Button gameCharacter2) {
        this.gameCharacter2 = gameCharacter2;
    }

    public Button getGameCharacter3() {
        return gameCharacter3;
    }

    public void setGameCharacter3(Button gameCharacter3) {
        this.gameCharacter3 = gameCharacter3;
    }

    public Button getGameCharacter4() {
        return gameCharacter4;
    }

    public void setGameCharacter4(Button gameCharacter4) {
        this.gameCharacter4 = gameCharacter4;
    }
}




