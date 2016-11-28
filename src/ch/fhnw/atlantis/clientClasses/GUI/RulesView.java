package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Nadine on 28.11.2016.
 */

public class RulesView {

    private VBox Regeln;
    private ScrollPane RegelnSP;
    private StackPane root;
    private Scene scene;

    private Button btnBack2;

    private ImageView AR1;
    private ImageView AR2;
    private ImageView AR3;
    private ImageView AR4;
    private ImageView AR5;
    private ImageView AR6;



    public RulesView() {

        root = new StackPane();

        // ------------------- Button -------------------
        btnBack2 = new Button("ZURÜCK ZUM MENU");
        btnBack2.setId("Button");

        // ------------------- Regeln -------------------
        Regeln = new VBox();
        AR1 = new ImageView(new Image(getClass().getResourceAsStream("./../../resources/images/AtlantisRegeln1.JPG")));
        AR2 = new ImageView(new Image(getClass().getResourceAsStream("./../../resources/images/AtlantisRegeln2.JPG")));
        AR3 = new ImageView(new Image(getClass().getResourceAsStream("./../../resources/images/AtlantisRegeln3.JPG")));
        AR4 = new ImageView(new Image(getClass().getResourceAsStream("./../../resources/images/AtlantisRegeln4.JPG")));
        AR5 = new ImageView(new Image(getClass().getResourceAsStream("./../../resources/images/AtlantisRegeln5.JPG")));
        AR6 = new ImageView(new Image(getClass().getResourceAsStream("./../../resources/images/AtlantisRegeln6.JPG")));

        Regeln.getChildren().addAll(btnBack2, AR1, AR2, AR3, AR4, AR5, AR6);
        RegelnSP = new ScrollPane(Regeln);

        root.getChildren().add(RegelnSP);

        scene = new Scene(root, 575, 650);


        RegelnSP.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");
    }

    // ------------------- View der Stage bekannt geben -------------------
    public void show(Stage stage) {
        stage.setTitle("Atlantis Regeln");
        stage.setResizable(false);
        // ------------------- Bild in Stage Titel laden  -------------------
        Image icon = new Image(getClass().getResourceAsStream("./../../resources/images/atlantis_client.jpg"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();


    }

    public VBox getRegeln() {
        return Regeln;
    }

    public void setRegeln(VBox regeln) {
        Regeln = regeln;
    }

    public ScrollPane getRegelnSP() {
        return RegelnSP;
    }

    public void setRegelnSP(ScrollPane regelnSP) {
        RegelnSP = regelnSP;
    }

    public StackPane getRoot() {
        return root;
    }

    public void setRoot(StackPane root) {
        this.root = root;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Button getBtnBack2() {
        return btnBack2;
    }

    public void setBtnBack2(Button btnBack2) {
        this.btnBack2 = btnBack2;
    }

    public ImageView getAR1() {
        return AR1;
    }

    public void setAR1(ImageView AR1) {
        this.AR1 = AR1;
    }

    public ImageView getAR2() {
        return AR2;
    }

    public void setAR2(ImageView AR2) {
        this.AR2 = AR2;
    }

    public ImageView getAR3() {
        return AR3;
    }

    public void setAR3(ImageView AR3) {
        this.AR3 = AR3;
    }

    public ImageView getAR4() {
        return AR4;
    }

    public void setAR4(ImageView AR4) {
        this.AR4 = AR4;
    }

    public ImageView getAR5() {
        return AR5;
    }

    public void setAR5(ImageView AR5) {
        this.AR5 = AR5;
    }

    public ImageView getAR6() {
        return AR6;
    }

    public void setAR6(ImageView AR6) {
        this.AR6 = AR6;
    }


}