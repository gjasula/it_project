package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.geometry.HPos;
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


/**
 * Created by Nadine on 18.10.2016.
 */

public class ServerView {

    private Scene scene;
    private GridPane serverpane;
    private BorderPane pane;
    private HBox spane;
    private StackPane stack;

    private Button btnConnect_s;
    private Button btnStop_s;
    private TextField ServerConnection;


    private Image icon;
    private Image img;
    private ImageView iview1;

    private Rectangle rect;
    private ColumnConstraints coll1;
    private ColumnConstraints coll2;
    private ColumnConstraints coll3;


    public ServerView() {

        // ------------------- Buttons -------------------
        btnConnect_s = new Button("START SERVER");
        btnStop_s = new Button("STOP SERVER");

        //  ------------------- TextField -------------------
        ServerConnection = new TextField("Server Value");
        //    ServerConnection.setText("Server Value");
        ServerConnection.setMinWidth(150);
        ServerConnection.setMinHeight(150);

        //  ------------------- Elemente in HBox anordnen  -------------------
        spane = new HBox(btnConnect_s, btnStop_s);
        spane.setAlignment(Pos.CENTER);
        spane.setPadding(new Insets(50));
        spane.setSpacing(15);
        spane.setId("Button");

        //  ------------------- Layout: Gridpane erstellen; anordnen; hinzufügen  -------------------
        serverpane = new GridPane();
        GridPane.setHalignment(spane, HPos.LEFT);
        GridPane.setHalignment(ServerConnection, HPos.CENTER);
        GridPane.setColumnSpan(ServerConnection, 2);

        serverpane.addRow(0, spane);
        serverpane.addRow(3, ServerConnection);
        serverpane.setPadding(new Insets(40, 40, 40, 40));
        serverpane.setVgap(80);
        serverpane.setHgap(400);
        serverpane.setGridLinesVisible(true);

        rect = new Rectangle(720, 550);
        rect.setFill(Color.rgb(200, 200, 200, 0.6));
        rect.setArcHeight(3.5);
        rect.setArcWidth(3.5);
        rect.setStroke(Color.LIGHTGRAY);

        stack = new StackPane();
        stack.getChildren().addAll(rect, serverpane);
        stack.setAlignment(Pos.CENTER);

        serverpane.getStyleClass().add("root");
        // BorderPane zu Scene hinzufügen und Fenstergrösse setzen
        scene = new Scene(stack, 1024, 640);
        scene.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");


    }
        public void show(Stage stage) {
            stage.setTitle("Atlantis by Team Gerstenland");
            Image icon = new Image(getClass().getResourceAsStream("./../../resources/images/atlantis_client.jpg"));
            stage.setResizable(false);
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();

        }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public GridPane getServerpane() {
        return serverpane;
    }

    public void setServerpane(GridPane serverpane) {
        this.serverpane = serverpane;
    }

    public BorderPane getPane() {
        return pane;
    }

    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    public HBox getSpane() {
        return spane;
    }

    public void setSpane(HBox spane) {
        this.spane = spane;
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

    public TextField getServerConnection() {
        return ServerConnection;
    }

    public void setServerConnection(TextField serverConnection) {
        ServerConnection = serverConnection;
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

    public ColumnConstraints getColl1() {
        return coll1;
    }

    public void setColl1(ColumnConstraints coll1) {
        this.coll1 = coll1;
    }

    public ColumnConstraints getColl2() {
        return coll2;
    }

    public void setColl2(ColumnConstraints coll2) {
        this.coll2 = coll2;
    }

    public ColumnConstraints getColl3() {
        return coll3;
    }

    public void setColl3(ColumnConstraints coll3) {
        this.coll3 = coll3;
    }

  }