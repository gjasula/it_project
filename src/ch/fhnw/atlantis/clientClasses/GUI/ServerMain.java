package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

/**
 *Created by Nadine on 03.11.2016.
 *Einstiegspunkt für JavaFx Anwendung - Stage stage zuweisung "Bühne"
 *Initialisiert das ch.fhnw.atlantis.clientClasses.GUI.Model
 */

public class ServerMain extends Application {
       public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        Model model = new Model(primaryStage);

        ServerController serverController = new ServerController(model);
        serverController.show();


    }
}
