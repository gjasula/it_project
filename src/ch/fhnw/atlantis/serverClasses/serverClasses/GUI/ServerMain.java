package ch.fhnw.atlantis.serverClasses.serverClasses.GUI;

import ch.fhnw.atlantis.clientClasses.Model;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *@Author Nadine
 *Einstiegspunkt für JavaFx Anwendung - Stage stage zuweisung "Bühne"
 *Initialisiert das Model
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