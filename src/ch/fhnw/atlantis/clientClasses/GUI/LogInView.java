package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Nadine on 18.10.2016.
 *
 * ist für die Präsentation der Daten zuständig
 * organisiert und speichert alle Elemente des GUI's
 * Style und Layout
 */

public class LogInView {

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


    public LogInView() {

        //  ------------------- Labels -------------------
        lbl1 = new Label();
        lbl1.setText("Willkommen in Atlantis");
        lbl2 = new Label();
        lbl2.setText(" Bitte wählen Sie ihre Verbindung");

        // ------------------- Labels VBox anordnen -------------------
        labelPane = new VBox(lbl1, lbl2);
        labelPane.setAlignment(Pos.CENTER);
        labelPane.setPadding(new Insets(40));
        labelPane.setSpacing(10);

        // ------------------- ID definieren für CSS aufruf -------------------
        labelPane.setId("Label");
        lbl1.setId("Label-big");

        // ------------------- Buttons erstellen -------------------
        btnConnect = new Button("SERVER VERBINDEN");
        btnClose = new Button("SCHLIESSEN");
        //btnAltConnect = new Button("ALTERNATIV SERVER");

        // ------------------- Labels erstellen -------------------
        IPLabel = new Label("IP Adresse");

        // ------------------- Textfield -------------------
        IPEnter = new TextField("185.xx.xx.xx");

        // ------------------- Buttons / Label / Textfield HBox anordnen -------------------
        buttonPane = new HBox(IPLabel, IPEnter, btnConnect, btnClose);
        buttonPane.setAlignment(Pos.BOTTOM_CENTER);
        buttonPane.setPadding(new Insets(0));
        buttonPane.setSpacing(10);
        buttonPane.setId("Button");

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
        player1.setId("Playerbefore");
        player2.setId("Playerbefore");
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
        BorderPane welcome_pane = new BorderPane();
        welcome_pane.setBottom(grid);
        welcome_pane.setCenter(buttonPane);
        welcome_pane.setTop(labelPane);
   //   welcome_pane.getStyleClass().add("root");
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

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public BorderPane getWelcome_pane() {
        return welcome_pane;
    }

    public void setWelcome_pane(BorderPane welcome_pane) {
        this.welcome_pane = welcome_pane;
    }

    public GridPane getGrid() {
        return grid;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    public HBox getButtonPane() {
        return buttonPane;
    }

    public void setButtonPane(HBox buttonPane) {
        this.buttonPane = buttonPane;
    }

    public VBox getLabelPane() {
        return labelPane;
    }

    public void setLabelPane(VBox labelPane) {
        this.labelPane = labelPane;
    }

    public HBox getImagePane() {
        return imagePane;
    }

    public void setImagePane(HBox imagePane) {
        this.imagePane = imagePane;
    }

    public Button getBtnConnect() {
        return btnConnect;
    }

    public void setBtnConnect(Button btnConnect) {
        this.btnConnect = btnConnect;
    }

    public Button getBtnAltConnect() {
        return btnAltConnect;
    }

    public void setBtnAltConnect(Button btnAltConnect) {
        this.btnAltConnect = btnAltConnect;
    }

    public Button getBtnClose() {
        return btnClose;
    }

    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    public TextField getIPEnter() {
        return IPEnter;
    }

    public void setIPEnter(TextField IPEnter) {
        this.IPEnter = IPEnter;
    }

    public Label getLbl1() {
        return lbl1;
    }

    public void setLbl1(Label lbl1) {
        this.lbl1 = lbl1;
    }

    public Label getLbl2() {
        return lbl2;
    }

    public void setLbl2(Label lbl2) {
        this.lbl2 = lbl2;
    }

    public Label getIPLabel() {
        return IPLabel;
    }

    public void setIPLabel(Label IPLabel) {
        this.IPLabel = IPLabel;
    }

    public ImageView getRoot() {
        return root;
    }

    public void setRoot(ImageView root) {
        this.root = root;
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