package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Nadine on 28.11.2016.
*/
public class RankingByeView {

    private Scene scene;
    private BorderPane Bpane;

    private VBox vbox;

    private TableView table;

    private Label lblResult;
    private Label lblEnd;

    public RankingByeView() {

            // ------------------- Labels -------------------
            //   lblResult = new Label("Resultat");
            //   lblResult.setAlignment(Pos.CENTER);

            lblEnd = new Label("Das Spiel ist beendet. Wir gratulieren zum Sieg. Du hast dich aufs Festland gerettet.");

            // vbox = new VBox(lblResult);

            // ------------------- Borderpane und Scene -------------------
            Bpane = new BorderPane();
            Bpane.setTop(lblEnd);
            //  Bpane.setCenter(vbox);


            scene = new Scene(Bpane, 1024, 640);

            Bpane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");


        }


    public void show(Stage stage){
        stage.setTitle("Atlantis ist versunken");
        stage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("./../../resources/images/atlantis_client.jpg"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

}


