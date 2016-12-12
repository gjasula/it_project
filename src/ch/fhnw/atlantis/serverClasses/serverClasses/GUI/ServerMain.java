package ch.fhnw.atlantis.serverClasses.serverClasses.GUI;

import ch.fhnw.atlantis.clientClasses.GUI.Model;
import ch.fhnw.atlantis.serverClasses.Server;
import javafx.application.Application;
import javafx.stage.Stage;

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
