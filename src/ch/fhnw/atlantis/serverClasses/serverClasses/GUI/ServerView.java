package ch.fhnw.atlantis.serverClasses.serverClasses.GUI;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author Nadine
 */

public class ServerView {

    private Scene scene;
    private HBox shbox;
    private VBox vbox;
    private VBox svbox;
    private StackPane stack;
    private BorderPane border;

    public Button btnConnect_s;
    private Button btnStop_s;

    private TextField PortServer;
    public TextArea txtLog;
    public static String txtLogString = "Server Initialising...";

    private Label SWelcome;
    private Label SGroup;
    private Label SStart;

    private Rectangle rect;

    private final static String newline = "\n";


    public ServerView() {

        // ------------------- Labels -------------------
        SWelcome = new Label("Willkommen in Atlantis");
        SWelcome.setId("Label-big");
        SStart = new Label("Bitte starten Sie den Server und die Client Anwendung!");
        SStart.setId("Label");

        SGroup = new Label("Team Gerstenland: IT-Projekt Fachhochschule Nordwestschweiz, 2016");
        SGroup.setId("Label-small");

        // ------------------- Buttons -------------------
        btnConnect_s = new Button("START SERVER");
        btnStop_s = new Button("STOP SERVER");

        //  ------------------- TextField -------------------
        PortServer = new TextField("7777");

        txtLog = new TextArea("");
        txtLog.setEditable(false);
        txtLog.setMaxWidth(500);
        txtLog.setWrapText(true);

        //  ------------------- Elemente in HBox anordnen  -------------------
        shbox = new HBox(PortServer, btnConnect_s, btnStop_s);
        shbox.setAlignment(Pos.CENTER_LEFT);
        shbox.setPadding(new Insets(5));
        shbox.setSpacing(5);
        shbox.setId("Button");

        vbox = new VBox(shbox, txtLog);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(50));

        svbox = new VBox(SWelcome, SStart);
        svbox.setAlignment(Pos.TOP_LEFT);


        //  ------------------- Retangle definieren und zu Stackpane hinzufügen  -------------------
        rect = new Rectangle(505, 50);
        rect.setFill(Color.rgb(160, 160, 160, 0.4));
        rect.setArcHeight(3.5);
        rect.setArcWidth(3.5);
        rect.setStroke(Color.LIGHTGRAY);
        rect.setVisible(true);

        stack = new StackPane();
        stack.getChildren().addAll(rect, svbox);
        stack.setAlignment(Pos.TOP_LEFT);
        stack.setPadding(new Insets(50));

        border = new BorderPane();
        border.setCenter(vbox);
        border.setTop(stack);
        border.setBottom(SGroup);

        // Beispiel für einen Listener
        //PortServer.textProperty().addListener((observable, oldValue, newValue) -> txtLog.appendText("test" + newline));

        //  -------------------BorderPane zu Scene hinzufügen und Fenstergrösse setzen-------------------
        scene = new Scene(border, 1024, 450);
        scene.getStylesheets().add("/ch/fhnw/atlantis/resources/css/serverstyle.css");
    }

    // ------------------- View der Stage bekannt geben -------------------
    public void show(Stage stage) {
        stage.setTitle("Atlantis by Team Gerstenland");
        Image icon = new Image(getClass().getResourceAsStream("/ch/fhnw/atlantis/resources/images/lighthouse.png"));
        stage.setResizable(false);
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    // ------------------- Getter Funktionen auf Element, für Interaktion -------------------
    public String getPortServer() {
        return PortServer.getText();
    }

    public void setPortServer(String portServer) {
        PortServer.setText(portServer);
    }

    public String getTxtLog() {
        return txtLogString;
    }

    public void setTxtLog(String LogMessage) {

        txtLogString = txtLogString + newline + LogMessage;

    }

    public void updateAll(){
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                // Nur txtLog kann sich beim Server ändern daher ein UpdateAll
                Platform.runLater(() -> txtLog.setText(getTxtLog())
                );
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Button getBtnConnect_s() {
        return btnConnect_s;
    }

    public void setBtnConnect_s(Button btnConnect_s) {
        this.btnConnect_s = btnConnect_s;
    }

    public Button getBtnStop_s() {
        return btnStop_s;
    }

    public void setBtnStop_s(Button btnStop_s) {
        this.btnStop_s = btnStop_s;
    }

}