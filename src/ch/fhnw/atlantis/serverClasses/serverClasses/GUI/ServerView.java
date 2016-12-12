package ch.fhnw.atlantis.serverClasses.serverClasses.GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;


/**
 * Created by Nadine on 18.10.2016.
 */

public class ServerView {

    private TextField textField;

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

    private Label SWelcome;
    private Label SGroup;
    private Label SStart;

    private Image icon;
    private Image img;
    private ImageView iview1;

    private Rectangle rect;

    private final static String newline = "\n";


    public ServerView() {

        // ------------------- Labels -------------------
        SWelcome = new Label("Willkommen in Atlantis");
        SStart = new Label("Bitte starten Sie den Server und die Client Anwendung, um das Spiel zu starten!");
        SGroup = new Label("Team Gerstenland: IT-Projekt Fachhochschule Nordwestschweiz, 2016");

        SGroup.setId("Label-small");

        // ------------------- Buttons -------------------
        btnConnect_s = new Button("START SERVER");
        btnStop_s = new Button("STOP SERVER");

        //  ------------------- TextField -------------------
        PortServer = new TextField("7777");

        txtLog = new TextArea("");
        txtLog.setEditable(false);
        txtLog.setMaxWidth(1004);
        txtLog.setWrapText(true);

        //  ------------------- Elemente in HBox anordnen  -------------------
        shbox = new HBox(PortServer, btnConnect_s, btnStop_s);
        shbox.setAlignment(Pos.CENTER);
        shbox.setPadding(new Insets(50));
        shbox.setSpacing(15);
        shbox.setId("Button");

        vbox = new VBox(shbox, txtLog);
        vbox.setAlignment(Pos.CENTER);

        svbox = new VBox(SWelcome, SStart);
        svbox.setAlignment(Pos.CENTER);


        //  ------------------- Retangle definieren und zu Stackpane hinzufügen  -------------------
        rect = new Rectangle(1024, 400);
        rect.setFill(Color.rgb(200, 200, 200, 0.4));
        rect.setArcHeight(3.5);
        rect.setArcWidth(3.5);
        rect.setStroke(Color.LIGHTGRAY);
        rect.setVisible(true);

        stack = new StackPane();
        stack.getChildren().addAll(rect, vbox);
        stack.setAlignment(Pos.CENTER);

        border = new BorderPane();
        border.setCenter(stack);
        border.setTop(svbox);
        border.setBottom(SGroup);

        //textField = new TextField("tet");
        //textField.textProperty().addListener((observable, oldValue, newValue) -> txtLog.appendText("test"));

        //  -------------------BorderPane zu Scene hinzufügen und Fenstergrösse setzen-------------------
        scene = new Scene(border, 1024, 450);
        scene.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");
    }

    // ------------------- View der Stage bekannt geben -------------------
    public void show(Stage stage) {
        stage.setTitle("Atlantis by Team Gerstenland");
        Image icon = new Image(getClass().getResourceAsStream("./../../../resources/images/atlantis.jpg"));
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

    public TextArea getTxtLog() {
        return txtLog;
    }

    public void setTxtLog(String LogMessage) {

        txtLog.appendText(LogMessage + newline);

    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public HBox getShbox() {
        return shbox;
    }

    public void setShbox(HBox shbox) {
        this.shbox = shbox;
    }

    public StackPane getStack() {
        return stack;
    }

    public void setStack(StackPane stack) {
        this.stack = stack;
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

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public ImageView getIview1() {
        return iview1;
    }

    public void setIview1(ImageView iview1) {
        this.iview1 = iview1;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public VBox getSvbox() {
        return svbox;
    }

    public void setSvbox(VBox svbox) {
        this.svbox = svbox;
    }

    public BorderPane getBorder() {
        return border;
    }

    public void setBorder(BorderPane border) {
        this.border = border;
    }

    public Label getSWelcome() {
        return SWelcome;
    }

    public void setSWelcome(Label SWelcome) {
        this.SWelcome = SWelcome;
    }

    public Label getSGroup() {
        return SGroup;
    }

    public void setSGroup(Label SGroup) {
        this.SGroup = SGroup;
    }

    public Label getSStart() {
        return SStart;
    }

    public void setSStart(Label SStart) {
        this.SStart = SStart;
    }
}