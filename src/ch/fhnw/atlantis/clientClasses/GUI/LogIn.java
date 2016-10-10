package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Nadine on 09.10.2016.
 */
public class LogIn extends Application{

    Button btn1, btn2;
    BorderPane pane1;
    Scene scene1, scene2;
    Stage thestage;



    public static void main(String[] args) {
        launch(args);}

    public void start(Stage primaryStage){
        thestage = primaryStage;

        btn1 = new Button("zu Server verbinden");
        btn2 = new Button("Spiel starten");

        ProgressIndicator pi = new ProgressIndicator();


        btn1.setOnMouseClicked(event -> {

                    btn2.setOnMouseClicked(event -> {
                    });

                //     getChildren().add(menu0);
                VBox vBox = new VBox(btn1);

        BorderPane pane1 = new BorderPane();
        pane1.setCenter(btn1);
        pane1.setCenter(btn2);
        pane1.setRight(pi);

        pane1.getChildren().addAll(btn1);


        scene1 = new Scene(pane1, 1300, 600);


        primaryStage.setTitle("Atlantis by Team Gerstenland");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

}
