package ch.fhnw.atlantis.clientClasses.GUI;import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Nadine on 25.10.2016.
 */


public class GameMenuView {
    private Scene scene;

    private BorderPane gameMenu_pane;
    private Stage gameMenu_stage;

    private MenuButton btnStartGame;
    private MenuButton btnOptions;
    private MenuButton btnExit;
    private MenuButton btnBack;

    private MenuButton btnSprache1;
    private MenuButton btnSprache2;

    private VBox menu0;
    private VBox menu1;

    public GameMenuView() {

        // ------------------- Buttons -------------------
        btnStartGame = new MenuButton("SPIEL STARTEN");
        btnOptions = new MenuButton("OPTIONEN");
        btnExit = new MenuButton("SCHLIESSEN");
        btnBack = new MenuButton("ZURÜCK");

        btnSprache1 = new MenuButton("DEUTSCH");
        btnSprache2 = new MenuButton("ENGLISCH");



        // Buttons in Layout Pane
        menu0 = new VBox(btnStartGame, btnOptions, btnExit, btnBack);
        menu0.setAlignment(Pos.BASELINE_LEFT);
        menu0.setPadding(new Insets(50));
        menu0.setSpacing(10);



        menu1 = new VBox(btnSprache1, btnSprache2);


        BorderPane GameMenu_pane = new BorderPane();
        GameMenu_pane.setLeft(menu0);

        scene = new Scene(GameMenu_pane, 800, 600);
        scene.getStylesheets().add("Resource/menu.css");

    }

    public void show(Stage stage) {

        stage.setTitle("Atlantis by Team Gerstenland");
        stage.setScene(scene);

        stage.show();

    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public BorderPane getGameMenu_pane() {
        return gameMenu_pane;
    }

    public void setGameMenu_pane(BorderPane gameMenu_pane) {
        this.gameMenu_pane = gameMenu_pane;
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