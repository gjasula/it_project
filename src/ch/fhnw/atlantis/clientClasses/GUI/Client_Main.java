package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Nadine on 12.10.2016.
 * Hauptklasse JavaFX Applikation erbt von javafx.application.Application
 * Einstiegspunkt für JavaFx Anwendung - Stage stage zuweisung "Bühne"
 * Initialisiert das ch.fhnw.atlantis.clientClasses.GUI.Model
 */

public class Client_Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model(primaryStage);

        LogInController logInController = new LogInController(model);
        logInController.show();
    }
}
