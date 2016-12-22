package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Author Nadine
 *
*/

public class RankingByeView {

    private Scene scene;
    private BorderPane Bpane;

    private HBox hbox;
    private VBox vbox;

    private Label lblResult;
    private Label lblEnd;
    private Label lbl;

    private Button endbtn;
    private Button restartbtn;

    public RankingByeView() {
        // ------------------- Buttons -------------------
        endbtn = new Button("SPIEL VERLASSEN");
        restartbtn = new Button("NEUES SPIEL");
        // ------------------- Labels -------------------
        lblResult = new Label("");
        lblEnd = new Label("Das Festland ist erreicht! Das Spiel ist beendet.");
        lblEnd.setWrapText(true);

        lbl = new Label();
        lbl.setText("Team Gerstenland: IT-Projekt Fachhochschule Nordwestschweiz, 2016");
        lbl.setId("Label-small");
        // ------------------- VBox -------------------
        vbox = new VBox(lblEnd, lblResult);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        hbox = new HBox(restartbtn, endbtn);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));

        // ------------------- Borderpane und Scene -------------------
        Bpane = new BorderPane();
        Bpane.setTop(vbox);
        Bpane.setPadding(new Insets(10));
        Bpane.setCenter(hbox);
        Bpane.setBottom(lbl);

        scene = new Scene(Bpane, 600, 460);
        // CSS
        Bpane.setId("RankingBye");
        hbox.setId("RankingByeButton");
        Bpane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/rankingstyle.css");
    }

    public void show(Stage stage) {
        stage.setTitle("Atlantis by Team Gerstenland: Danke und Tschüss");
        stage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("./../../resources/images/atlantis_client.jpg"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    //------------------------- Getter and Setter ---------------------------
    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public BorderPane getBpane() {
        return Bpane;
    }

    public void setBpane(BorderPane bpane) {
        Bpane = bpane;
    }

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox hbox) {
        this.hbox = hbox;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public Label getLblResult() {
        return lblResult;
    }

    public void setLblResult(Label lblResult) {
        this.lblResult = lblResult;
    }

    public Label getLblEnd() {
        return lblEnd;
    }

    public void setLblEnd(Label lblEnd) {
        this.lblEnd = lblEnd;
    }

    public Button getEndbtn() {
        return endbtn;
    }

    public void setEndbtn(Button endbtn) {
        this.endbtn = endbtn;
    }

    public Button getRestartbtn() {
        return restartbtn;
    }

    public void setRestartbtn(Button restartbtn) {
        this.restartbtn = restartbtn;
    }
}