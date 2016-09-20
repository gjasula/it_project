package ch.fhnw.atlantis.clientClasses;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by team Gerstenland.
 *
 */

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception {

        StackPane root = new StackPane();

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Atlantis - Server - Team Gerstenland");
        stage.setScene(scene);
        stage.show();

    }
}