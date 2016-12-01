package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Created by Nadine on 28.11.2016.

public class RankingByeView {


    private Scene scene;
    private BorderPane Bpane;

    private Label lblResult;
    private Label lblEnd;


    public RankingByeView(TableView tableView) {
        this.TableView = tableView;


 //   public RankingByeView() {
            // ------------------- Labels -------------------
            lblResult = new Label("Resultat");
            lblEnd = new Label("Das Spiel ist beendet");


            // ------------------- Tabelle erstellen-------------------
            TabelView<Ranking> table = new TabelView<Ranking>();
            table.getItems().add(r);
            table.setPrefWidth(750);

            // Spaltentitel
            TableColumn<Ranking, Integer> rank = new TableColumn<Ranking, Integer>("Rang");
            rank.setCellValueFactory(new PropertyValueFactory<Ranking, Integer>("TotalRank"));

            TableColumn<Ranking, String> player = new TableColumn<Ranking, String>("Spieler");
            player.setCellValueFactory(new PropertyValueFactory<Ranking, String>("User"));

            TableColumn<Ranking, Integer> points = new TableColumn<Ranking, Integer>("Punkte");
            points.setCellValueFactory(new PropertyValueFactory<Ranking, Integer>("TotalPoints"));

            table.getColumns().addAll();


            // ------------------- Borderpane und Scene -------------------
            Bpane = new BorderPane();
            Bpane.setTop(lblEnd);


            scene = new Scene(Bpane, 600, 600);
            Bpane.getStylesheets().add("/ch/fhnw/atlantis/resources/css/style.css");


        }
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


*/