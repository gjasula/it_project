package ch.fhnw.atlantis.clientClasses.GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Nadine
 * Hauptklasse JavaFX Applikation erbt von javafx.application.Application
 * Einstiegspunkt für JavaFx Anwendung - Stage stage zuweisung "Bühne"
 * Initialisiert das ch.fhnw.atlantis.clientClasses.GUI.Model
 */

public class Client_Main extends Application {
    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(final Stage primaryStage) throws FileNotFoundException {
        Model model = new Model(primaryStage);

        LogInController logInController = new LogInController(model);
        logInController.show();

        primaryStage.setOnCloseRequest(event -> {
        event.consume();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Soll Atlantis wirklich beendet werden?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Spiel verlassen");
        alert.initOwner(primaryStage);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get()== ButtonType.YES){
            Platform.exit();
            System.out.println("Atlantis ist geschlossen");
        }
    });

    }


}

